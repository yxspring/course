<template>
    <div>
        <h1>您好，欢迎访问首页！</h1>
    </div>
</template>

<script>
    export default {
        name: "welcome",
        mounted:function () {
           this.$parent.activeSidebar("welcome-sidebar");
        }
    }
</script>