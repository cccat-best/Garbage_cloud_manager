<template>
	<view>
		<view class="score">
			<image
				src="@/static/score.png" 
				mode="scaleToFill"
				style="width: 100px;height: 100px;border-radius: 20px;"
			></image>
			<view class="text">
				我的积分:{{score}}分
			</view>
		</view>
		<view class="text1">
			好物兑换
		</view>
		<view class="goods">
			<view class="item" v-for="(item,index) in gifts" :key="index">
				<image
					:src="item.src" 
					mode="scaleToFill"
					style="width: 100px;height: 100px;margin-top: 30px;"
				></image>
				<view class="name">
					{{item.name}}
				</view>
				<view class="price">
					{{item.credit}}分
				</view>
				<view class="btn" @click="toggle(item.id,item.credit)">
					兑换
				</view>
			</view>
		</view>
		<view>
			<uni-popup ref="popup" background-color="#fff">
				<view style="padding: 50px 30px;">
					<uni-forms ref="form" :modelValue="baseFormData" :rules="rules" class="popup">
						<uni-forms-item name="name" label="收件人" required>
							<uni-easyinput v-model="baseFormData.name" placeholder="请输入收件人姓名" />
						</uni-forms-item>
						<uni-forms-item name="phone" label="电话" required>
							<uni-easyinput v-model="baseFormData.phone" placeholder="请输入电话" />
						</uni-forms-item>
						<uni-forms-item name="address" label="收货地" required>
							<uni-easyinput v-model="baseFormData.address" placeholder="请输入收货地址" />
						</uni-forms-item>
					</uni-forms>
					<button type="primary" size="mini" style="float: right;"
					@click="change()"
					>一键兑换</button>
				</view>
			</uni-popup>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				baseFormData: {
					name: '',
					phone:'',
					address:''
				},
				rules: {
					name: {
						rules: [{
								required: true,
								errorMessage: '请输入收件人',
							}
						]
					},
					phone: {
						rules: [{
								required: true,
								errorMessage: '请输入电话',
							},
							{
								minLength: 11,
								maxLength: 11,
								errorMessage: '请输入正确的手机号',
							}
						]
					},
					address: {
						rules: [{
								required: true,
								errorMessage: '请输入收件地址',
							}
						]
					},
				},
				giftId:0,
				userId:0,
				score:0,
				gifts:[
					{
						id: 1,
						name: "头戴式蓝牙耳机",
						credit: 1000,
						src:'../../static/phone.png'
					},
					{
						id: 2,
						name: "保温水杯",
						credit: 200,
						src:'../../static/object.png'
					},
					{
						id: 3,
						name: "20000毫安充电宝",
						credit: 500,
						src:'../../static/object2.png'
					},
					{
						id: 4,
						name: "碳素签字笔",
						credit: 100,
						src:'../../static/object3.png'
					},
					{
						id: 5,
						name: "毛绒玩具",
						credit: 1000,
						src:'../../static/object4.png'
					}
				]
			}
		},
		onLoad() {
			this.userId = uni.getStorageSync('userId');
			this.getScore()
		},
		methods: {
			toggle(id,credit) {
				this.giftId=id;
				if(this.score<credit){
					uni.showToast({
						title: '积分不足',
						icon:'error',
						duration: 2000
					});
				}else{
					this.$refs.popup.open()
				}
			},
			change() {
				this.$refs.form.validate().then(res=>{
					uni.request({
					    url: 'https://rmb.sipcoj.com/shop/convent',
						method:"POST",
					    data: {
					       userId: this.userId,
						   giftId: this.giftId,
						   receiver: this.baseFormData.name,
						   address: this.baseFormData.address,
						   phone: this.baseFormData.phone
					    },
					    header: {
					        "content-type":"application/json",
					    },
					    success: (res) => {
							if(res.data.code=='00000'){
								uni.showToast({
									title: '兑换成功'
								});
								this.getScore()
								this.$refs.popup.close()
							} else {
								uni.showToast({
									title: res.data.message,
									icon:'none'
								});
							}
					    }
					});
				}).catch(err =>{
					console.log('表单错误信息：', err);
				})
			},
			getScore(){
				uni.request({
				    url: 'https://rmb.sipcoj.com/user/c/credit',
					method:"GET",
				    data: {
				       userId: this.userId
				    },
				    header: {
				        "content-type":"application/json",
				    },
				    success: (res) => {
						if(res.data.code=='00000'){
							this.score=res.data.data.credit
						} else {
							uni.showToast({
								title: res.data.message,
								icon:'none'
							});
						}
				    }
				});
			}
		}
	}
</script>

<style scoped lang="scss">
.score{
	text-align: center;
	// background-color: red;
	margin-top: 30px;
	padding-bottom: 30px;
	border-bottom: 2px dotted #D4D7DE;
	.text{
		font-size: 20px;
		font-weight: 700;
		color: #1296db;
	}
}
.text1{
	font-size: 18px;
	font-weight: 700;
	color: gray;
	padding-left: 30px;
	margin-top: 20px;
}
.goods{
	width: 90%;
	margin: 0 auto;
	// background-color: red;
	display: flex;
	justify-content: space-between;
	flex-wrap: wrap;
	padding-bottom: 30px;
	.item{
		display: inline-block;
		// margin-left: 20px;
		border-radius: 5px;
		height: 270px;
		width: 45%;
		border: 1px solid #D4D7DE;
		text-align: center;
		margin-top: 20px;
		.name{
			margin-top: 25px;
			color: #606266;
		}
		.price{
			margin-top: 15px;
			color: #1296db;
		}
		.btn{
			color: #606266;
			margin-top: 15px;
			height: 30px;
			line-height: 30px;
			font-weight: 700;
			border-top: 1px solid #D4D7DE;
			// background-color: rebeccapurple;
		}
		
	}
}
.popup{
	padding: 20px;
}
</style>
