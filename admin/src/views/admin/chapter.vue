<template>
    <div>
        <p>
            <button v-on:click="add()" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-edit"></i>
                新增
            </button>
            &nbsp;
            <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-refresh"></i>
                刷新
            </button>
        </p>
        <pagination ref="pagination" v-bind:list="list"></pagination>
        <table id="simple-table" class="table  table-bordered table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>课程id</th>
                <th>课程名称</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="chapter in chapters">
                <td>{{chapter.id}}</td>
                <td>{{chapter.courseId}}</td>
                <td>{{chapter.name}}</td>
                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button class="btn btn-xs btn-info" v-on:click="edit(chapter)">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>
                        <button class="btn btn-xs btn-danger" v-on:click="del(chapter.id)">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <!--modal-->
        <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">表单</h4>
                    </div>
                    <div class="modal-body">
                        <!--表单内容-->
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input type="text" v-model="chapter.name" class="form-control" placeholder="名称" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程Id</label>
                                <div class="col-sm-10">
                                    <input type="text" v-model="chapter.courseId" class="form-control" placeholder="课程Id">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary" v-on:click="save()">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</template>
<script>
    //分页组件
    import Pagination from '../../components/pagination.vue';
    export default {
        //应用分页组件
        components:{Pagination},
        name: "chapter",
        data:function(){
            return {
                chapter:{},
                chapters:[]
            }
        },
        mounted:function () {
            let _this=this;
            _this.list(1);
            // this.$parent.activeSidebar("business-chapter-sidebar");
        },
        methods:{
            add(){
                let _this = this;
                _this.chapter={};
                $("#form-modal").modal("show");
            },

            list(page){
                let _this = this;
                _this.$ajax.post("http://127.0.0.1:9000/business/admin/chapter/list",{
                    page:page,
                    pageSize:_this.$refs.pagination.size,
                }).then((response)=>{
                    console.log("查询大章列表结果："+response);
                    let resp=response.data;
                    _this.chapters=resp.content.list;
                    _this.$refs.pagination.render(page,resp.content.total);
                })
            },

            save(page){
                let _this = this;
                _this.$ajax.post("http://127.0.0.1:9000/business/admin/chapter/save",_this.chapter).then((response)=>{
                    let resp=response.data;
                    if (resp.success){
                        $("#form-modal").modal("hide");
                        _this.list(1);
                    }else{
                        alert("保存失败！");
                    }
                })
            },

            edit(chapter){
                let _this = this;
                _this.chapter=$.extend({},chapter);
                $("#form-modal").modal("show");
            },

            del(id){
                let _this = this;
                _this.$ajax.delete("http://127.0.0.1:9000/business/admin/chapter/delete/"+id).then((response)=>{
                    let resp=response.data;
                    if (resp.success){
                        _this.list(1);
                    }else{
                        alert("删除失败！");
                    }
                })
            },
        }
    }
</script>