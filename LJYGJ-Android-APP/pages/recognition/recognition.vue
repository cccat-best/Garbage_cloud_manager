<template>
	<view class="body">
		<view class="uni-margin-wrap">
			<swiper class="swiper" circular indicator-dots="true" autoplay="true" interval="2500" duration="800">
				<swiper-item>
					<image class="item" src="../../static/pic.jpg" mode="aspectFill"></image>
				</swiper-item>
				<swiper-item>
					<image class="item" src="../../static/pic3.jpg" mode="aspectFill"></image>
				</swiper-item>
				<swiper-item>
					<image class="item" src="../../static/pic2.jpg" mode="aspectFill"></image>
				</swiper-item>
				<swiper-item>
					<image class="item" src="../../static/pic4.jpg" mode="aspectFill"></image>
				</swiper-item>
			</swiper>
		</view>
		<!-- <uni-search-bar radius="5" placeholder="文字搜索识别" clearButton="auto" cancelButton="auto" @confirm="search" /> -->
		<view class="btn">
			<view class="item" @click="textSearch">
				<view class="text">
					垃圾检索
				</view>
				<view class="text2">
					garbage retrieval
				</view>
				<image src="../../static/text.png" mode="scaleToFill" style="width: 70px;height: 73px; position: absolute; right: 60px;bottom: 25px;"></image>
			</view>
			<view class="item" @click="pictureSearch">
				<view class="text">
					智能识别
				</view>
				<view class="text2">
					intelligent identify
				</view>
				<image src="../../static/phonepic.png" mode="scaleToFill" style="width: 80px;height: 70px; position: absolute; right: 50px;bottom: 25px;"></image>
			</view>
		</view>
		<view class="top" @click="detail">
			<view class="text">
				垃圾桶详情
			</view>
			<view class="text2">
				trash bin details
			</view>
			<image 
			src="../../static/detail.png" 
			mode="scaleToFill" 
			style="width: 85px;height: 85px; position: absolute; right: 50px;top: 20px;"></image>
		</view>
		<view class="top" @click="knowledge">
			<view class="text">
				分类常识
			</view>
			<view class="text2">
				garbage sorting knowledge
			</view>
			<image src="../../static/knowledge.png" mode="scaleToFill" style="width: 80px;height: 80px; position: absolute; right: 50px;top: 20px;"></image>
		</view>
		<!-- <view class="top" @click="voiceSearch">
			<view class="text">
				语音识别
			</view>
			<view class="text2">
				search with voice
			</view>
			<image src="../../static/语音 (1).png" mode="scaleToFill" style="width: 70px;height: 70px; position: absolute; right: 60px;top: 35px;"></image>
		</view> -->
	</view>
</template>

<script>
	export default {
		data() {
			return {
			}
		},
		methods: {
			textSearch(){
				uni.navigateTo({
					url: '/pages/recognition/textSearch/textSearch'
				});
			},
			pictureSearch(){
				uni.navigateTo({
					url: '/pages/recognition/pictureSearch/pictureSearch'
				});
			},
			detail(){
				uni.navigateTo({
					url: '/pages/recognition/details/detailshome'
				});
			},
			knowledge(){
				uni.navigateTo({
					url: '/pages/recognition/knowledge/knowledge'
				});
			}
		}
	}
</script>

<style scoped lang="scss">
.body{
	// background-color: #40974c;
	padding-bottom: 15px;
}
.uni-margin-wrap,.swiper,.item{
	height: 200px;
	width: 100%;
}
.uni-margin-wrap{
	// margin-bottom: 10px;
}

.btn{
	display: flex;
	justify-content: center;
	gap:12px;
	margin-top: 20px;
	.item{
		height: 200px;
		width: 45%;
		border-radius: 10px;
		box-shadow: 0 0 5px #D4D7DE;
		position: relative;
	}
}

.top{
	height: 110px;
	width: 93%;
	border-radius: 10px;
	position: relative;
	box-shadow: 0 0 5px #D4D7DE;
	// box-shadow: 0 0 5px #32793c;
	// border: 2px solid #32793c;
	margin: 0 auto;
	margin-top: 15px;
}
.text{
	display: inline-block;
	font-size: 23px;
	color: #606266;
	font-weight: 700;
	margin-left: 20px;
	margin-top: 20px;
}
.text2{
	font-size: 15px;
	color: #606266;
	font-weight: 700;
	margin-left: 20px;
	margin-top: 5px;
}
</style>
