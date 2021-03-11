Confirm = {
    show:function(message,callback){
        Swal.fire({
            title: '确定吗?',
            text:message,
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '确定'
        }).then((result) => {
            if (result.isConfirmed) {
                if (callback){
                    callback()
                }
            }
        })
    }
}