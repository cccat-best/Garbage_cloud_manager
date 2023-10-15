<template>
  <view class="content">
    <image src="@/static/rubbish.png" alt="" class="bg-img"></image>
    <view class="title">登录</view>
    <uni-forms ref="form" :modelValue="formData" :rules="rules" class="form">
      <uni-forms-item  name="account" >
        <uni-easyinput prefixIcon="person" type="text"  v-model="formData.account" placeholder="请输入账号" />
      </uni-forms-item>
      <uni-forms-item  name="password" >
        <uni-easyinput prefixIcon="locked" type="password" v-model="formData.password" placeholder="请输入密码"></uni-easyinput>
      </uni-forms-item>
    </uni-forms>
    <view class="tip">忘记密码？</view>
    <view class="btn">
      <button type="primary" @click="submit()" class="bottonNormal">
        登录
      </button>
    </view>
    <view class="register" @click="goRegister">注册账号</view>
    <view class="checkbox">
      <checkbox  :checked="ischeck" @click="change"/>已阅读并同意用户隐私协议
    </view>
  </view>
</template>

<script>
  export default {
   data() {
   		return {
        ischeck:false,
   			// 表单数据
   			formData: {
   				account: '',
   				password: ''
   			},
   			rules: {
   				account: {
   					rules: [{
   							required: true,
   							errorMessage: '请输入账号',
   						},
   						{
   							minLength: 3,
   							maxLength: 11,
   							errorMessage: '账号长度在 {minLength} 到 {maxLength} 个字符',
   						}
   					]
   				},
				password: {
					rules: [{
							required: true,
							errorMessage: '请输入密码',
						}
					]
				},
   			}
   		}
   	},
    methods: {
     change() {
       this.ischeck = !this.ischeck
       console.log(this.ischeck);
     },
	 goRegister(){
		 uni.redirectTo({
		 	url: '/pages/register/register'
		 });
	 },
	 submit(){
		 this.$refs.form.validate().then(res=>{
			if(this.ischeck){
			 uni.request({
				 url: 'https://rmb.sipcoj.com/user/c/login',
				method:"POST",
				 data: {
					username:this.formData.account,
					password:this.formData.password,
				 },
				 header: {
					 "content-type":"application/json",
				 },
				 success: (res) => {
					if(res.data.code=='00000'){
						uni.setStorage({
						  key: "token",
						  data: res.data.data.token,
						});
						uni.setStorage({
						  key: "userId",
						  data: res.data.data.userId,
						});
						uni.switchTab({
							url: '/pages/recognition/recognition'
						});
					} else {
						uni.showToast({
							title: res.data.message,
							icon:'none'
						});
					}
				 }
			 });
			}else{
			 uni.showToast({
				title: '请先同意用户隐私协议',
				icon:'none'
			 });
			}
		}).catch(err =>{
			console.log('表单错误信息：', err);
		})
	 }
    }
  }
</script>

<style lang="scss" scoped>
  * {
    margin: 0;
    padding: 0;
  }

  .content {
    // height: 100vh;
	margin-top: 30px;
    width: 100vm;
	padding-left: 40px;
	padding-right: 40px;
    .bg-img {
      position: absolute;
      z-index: -1;
      left: 0;
      right: 0;
      bottom: 0;
      right: 0;
      width: 100%;
      height: 40vh;
    }

    .title {
      width: 100%;
      height: 10vh;
      line-height: 10vh;
      font-size: 35px;
      color: #327696;
      font-weight: bold;
      display: flex;
      justify-content: center;
      margin-bottom: 40px;
    }
    .form {
      height: 22vh;
      width: 100%;
    }
    .tip{
      float: right;
      font-size: 15px;
      color: #a3c5d9;
      margin-top: -15px;
    }
    .btn {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 100%;
      .bottonNormal {
        border-radius: 20px;
        background-color: #77aed5;
        align-items: center;
        justify-content: center;
        display: flex;
        width: 65vw;
        height: 70rpx;
        margin: 20px auto;
        
      }
    }
    .register {
      display: flex;
      justify-content: center;
      align-items: center;
      color: #6b8292;
      margin-bottom: 15px;
    }
    .checkbox {
      display: flex;
      justify-content: center;
      align-items: center;
      font-size: 12px;
      margin-top: 10px;
    }
  }
  ::v-deep .uni-easyinput__content-input {
    height: 75rpx !important;
    border-radius: 20px !important;
  }
  ::v-deep .uni-forms-item {
    margin-bottom: 40px !important;
  }
  ::v-deep .is-input-border {
    border-radius: 10px;
  }
  input {
    outline: none;
    padding: 15px;
    width: 100%;
    border-radius: 20px !important;
    margin-bottom: 10px;
    box-sizing: border-box;
    font-size: 16px;
    height: 80px;
  }
</style>