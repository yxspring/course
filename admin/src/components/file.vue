<template>
   <div>
       <button type="button" v-on:click="selectFile()" class="btn btn-white btn-default btn-round">
           <i class="ace-icon fa fa-upload"></i>
           {{text}}
       </button>
       <input class="hidden" type="file" ref="file" v-on:change="uploadFile()" v-bind:id="inputId+'-input'">

   </div>
</template>

<script>
    export default {
        name: 'pagination',
        props: {
            text:{
                default:"上传文件"
            },
            inputId:{
                default:"file-upload"
            },
            suffixs:{
                default:['jpg','png','jpeg']
            },
            use:{
                default:""
            },
            afterUpload: {
                type: Function,
                default: null
            },
            itemCount: Number // 显示的页码数，比如总共有100页，只显示10页，其它用省略号表示
        },
        data: function () {
            return {

            }
        },
        methods: {
            /*上传图片*/
            uploadFile(){
                let _this=this;
                let formData=new window.FormData();
                //增加文件上传校验
                let file=_this.$refs.file.files[0];
                let file_name=file.name.substring(file.name.lastIndexOf(".")+1).toLowerCase();
                /*只支持jpg png  jpeg格式的文件上传*/
                let suffixs=_this.suffixs;
                let validateSuffix=false;
                for (var i=0;i<suffixs.length;i++){
                    if (suffixs[i].toLowerCase()==file_name){
                        validateSuffix=true;
                        break;
                    }
                }
                if (!validateSuffix){
                    Toast.warning("文件格式不正确！必须上传"+suffixs.join(",")+"类型的文件");
                    $("#"+_this.inputId+"-input").val("");
                    return;
                }
                //key:"file"必须和后端controller参数名一致
                formData.append('file',file);
                formData.append('use',_this.use);
                Loading.show();
                _this.$ajax.post(process.env.VUE_APP_SERVER+'/file/admin/upload',formData).then((response)=>{
                    Loading.hide();
                    let resp=response.data;
                    _this.afterUpload(resp);
                    $("#"+_this.inputId+"-input").val("");
                })
            },
            /*点击上传照片按钮*/
            selectFile(){
                let _this=this;
                /*触发 input 元素的 click 事件：*/
                $("#"+_this.inputId+"-input").trigger("click");
            }
        }
    }
</script>

<style scoped>
    .pagination {
        vertical-align: middle !important;
        font-size: 16px;
        margin-top: 0;
        margin-bottom: 10px;
    }

    .pagination button {
        margin-right: 5px;
    }

    .btn-primary.active {
        background-color: #2f7bba !important;
        border-color: #27689d !important;
        color: white !important;
        font-weight: 600;
    }

    /*.pagination select {*/
    /*vertical-align: middle !important;*/
    /*font-size: 16px;*/
    /*margin-top: 0;*/
    /*}*/
</style>
