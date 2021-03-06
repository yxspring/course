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
                        <button class="btn btn-xs btn-success">
                            <i class="ace-icon fa fa-check bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-danger">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-warning">
                            <i class="ace-icon fa fa-flag bigger-120"></i>
                        </button>
                    </div>

                    <div class="hidden-md hidden-lg">
                        <div class="inline pos-rel">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                            </button>

                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                <li>
                                    <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                          <span class="blue">
                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                          </span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                          <span class="green">
                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                          </span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                          <span class="red">
                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                          </span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
        <!--modal-->
        <div class="modal fade" tabindex="-1" role="dialog">
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
                                    <input type="text" class="form-control" placeholder="名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程Id</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" placeholder="课程Id">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
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
                $(".modal").modal("show");
            },
            list(page){
                let _this = this;
                _this.$ajax.post("http://127.0.0.1:9000/business/admin/chapter/list",{
                    page:page,
                    pageSize:_this.$refs.pagination.size,
                }).then((response)=>{
                    console.log("查询大章列表结果："+response);
                    _this.chapters=response.data.list;
                    _this.$refs.pagination.render(page,response.data.total);
                })
            }
        }
    }
</script>