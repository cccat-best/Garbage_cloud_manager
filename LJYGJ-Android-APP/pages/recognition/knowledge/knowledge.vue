<template>
	<view class="recoverable">
		<view class="sort">
			<view class="item" @click="goRecoverable" style="background-color: #bef1c8;">
				<image
					src="../../../static/1.png" 
					mode="scaleToFill"
					style="width: 100px;height: 100px;border-radius: 20px;"
					></image>
				<view class="text">
					可回收垃圾
				</view>
			</view>
			<view class="item" @click="goOther" style="background-color: #e8e5e2;">
				<image
					src="../../../static/4.png" 
					mode="scaleToFill"
					style="width: 100px;height: 100px;border-radius: 20px;"
					></image>
				<view class="text">
					其他垃圾
				</view>
			</view>
			<view class="item" @click="goHarmful" style="background-color: #f9eae9;">
				<image
					src="../../../static/2.png" 
					mode="scaleToFill"
					style="width: 100px;height: 100px;border-radius: 20px;"
					></image>
				<view class="text">
					有害垃圾
				</view>
			</view>
			<view class="item" @click="goFood" style="background-color: #e0eaf6;">
				<image
					src="../../../static/3.png" 
					mode="scaleToFill"
					style="width: 100px;height: 100px;border-radius: 20px;"
					></image>
				<view class="text">
					厨余垃圾
				</view>
			</view>
		</view>
		<view class="article">
			<view class="news" style="margin-top: 0;">
				<uni-link href="http://health.people.com.cn/n1/2022/0124/c14739-32338084.html" class="text">
					垃圾分类，人人受益
				</uni-link>
				<view class="text2">
					　如今，垃圾分类在全国多地深入实施。然而，现实中一些居民还未参与到垃圾分类中...
				</view>
			</view>
			<view class="news">
				<uni-link href="http://opinion.people.com.cn/n1/2023/0524/c223228-32693808.html" class="text">
					推动垃圾分类成为低碳生活新时尚
				</uni-link>
				<view class="text2">
					　垃圾分类、节约资源，变废为宝、利国利民。实行垃圾分类，关系广大人民群众生活环境...
				</view>
			</view>
			<view class="news">
				<uni-link href="https://zhuanlan.zhihu.com/p/519243237" class="text">
					2021在垃圾分类领域出台的政策
				</uni-link>
				<view class="text2">
					　“十四五”时期，生活垃圾分类和处理设施建设进入关键时期。推动实施生态环境高水平保护...
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			goRecoverable(){
				uni.navigateTo({
					url: './knowledgeDetail/recoverable'
				});
			},
			goOther(){
				uni.navigateTo({
					url: './knowledgeDetail/other'
				});
			},
			goHarmful(){
				uni.navigateTo({
					url: './knowledgeDetail/harmful'
				});
			},
			goFood(){
				uni.navigateTo({
					url: './knowledgeDetail/foodWaste'
				});
			}
		}
	}
</script>

<style scoped lang="scss">
.recoverable{
	height: 100vh;
	background-color: white;
}
.sort{
	height: 350px;
	display: flex;
	justify-content: space-around;
	flex-wrap: wrap;
	padding-top: 30px;
	.item{
		width: 140px;
		height: 130px;
		text-align: center;
		border-radius: 10px;
		padding-top: 10px;
		background-color: rgb(248, 248, 248);
		.text{
			color: #606266;
			text-align: center;
		}
	}
}
.article{
	padding-bottom: 40px;
	.news{
		height: 80px;
		width: 84%;
		margin: 0 auto;
		border-radius: 10px;
		background-color: #F5F7FA;
		margin-top: 15px;
		// box-shadow: 0 0 5px #D4D7DE;
		.text{
			color: #606266;
			font-size: 18px;
			font-weight: 700;
			padding-top: 10px;
			padding-left: 15px;
		}
		.text2{
			color: #606266;
			font-size: 13px;
			padding-top: 10px;
			padding-left: 15px;
			padding-right: 15px;
		}
	}
}
</style>
