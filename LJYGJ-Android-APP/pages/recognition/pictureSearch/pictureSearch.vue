<template>
	<view>
		<view class="result" v-if="show">
			<view style="text-align: center;">
				<image
					:src="src" 
					mode="scaleToFill"
					style="width: 300px;height: 400px;border-radius: 20px;margin: 0 auto;"
					></image>
				<view class="text">
					{{ text }}
				</view>
			</view>
		</view>
		<view class="noSearch" v-if="!show">
			<view>
				<image src="../../../static/none.png" mode="aspectFill"></image>
				<view class="text">
					{{ text }}
				</view>
			</view>
		</view>
		<view class="btn">
			<view class="pic" @click="takePicture">
				点击拍照识别
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				show:false,
				src:'../../../static/3.png',
				text:'暂时木有内容呀～～',
				userId:0,
				filePath:''
			}
		},
		methods: {
			takePicture(){
				let _self=this
				uni.chooseImage({
					count: 1,
					sizeType: ['original', 'compressed'],
					sourceType: ['camera'],
					success: function (res) {
						// console.log(JSON.stringify(res.tempFilePaths));
						_self.filePath=res.tempFilePaths[0]
						uni.showLoading({
							title: '识别中'
						})
						uni.uploadFile({
						  url: "https://rmb.sipcoj.com/garbage/identify", 
						  filePath: _self.filePath,
						  name: "file",
						  formData: {
						    userId:_self.userId,
						    garbageId:2
						  },
						  header: {
						    "content-type": "multipart/form-data",
						  },
						  success: (res) => {
							  uni.hideLoading();
							  // console.log(res.data)
							  // console.log(JSON.parse(res.data))
							  let identify=JSON.parse(res.data)
								if(identify.code=='00000'){
									_self.show=true
									var list1=identify.data.list
									var list = Array.from(new Set(list1))
									_self.src=identify.data.url
									_self.text='此图片中包含有'
									for(var i=0;i<list.length;i++){
										_self.text=_self.text+list[i]+' '
									}
								} else {
									_self.show=false
									_self.src='../../../static/3.png'
									_self.text='暂时木有内容呀～～'
								}
							},
							fail: (err) => {
								uni.hideLoading();
								uni.showToast({
									content: '识别失败',
									icon: 'error'
								});
							},
						});
					}
				});
			},
		},
		onLoad() {
			this.userId = uni.getStorageSync('userId');
		}
	}
</script>

<style scoped lang="scss">
.noSearch {
	height: 50vh;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 50px;
}

.result {
	// background-color: firebrick;
	height: 55vh;
	margin-top: 70px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.text {
	text-align: center;
	padding: 0 30px;
	margin-top: 30px;
	font-size: 20px;
	color: #606266;
}

.btn {
	// background-color: orange;
	position: fixed;
	bottom: 17vh;
	height: 45px;
	width: 100%;

	.pic {
		text-align: center;
		font-size: 20px;
		width: 88%;
		margin: 0 auto;
		line-height: 45px;
		color: #606266;
		border-radius: 8px;
		// border: 1px solid #606266;
		box-shadow: 0 0 5px #D4D7DE;
	}
}
</style>
