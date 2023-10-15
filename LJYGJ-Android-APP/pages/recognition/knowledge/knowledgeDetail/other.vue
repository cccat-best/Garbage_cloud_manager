<template>
	<view class="body">
		<view class="pic">
			<image
				src="@/static/4.png" 
				mode="scaleToFill"
				style="width: 200px;height: 200px;border-radius: 20px;"
			></image>
		</view>
		<view class="title">
			其他垃圾:
		</view>
		<view class="text">
			其他垃圾，又称干垃圾，指除可回收物、有害垃圾、厨余垃圾以外的其它生活废弃物。这类垃圾不会腐烂，危害大多较小，但无再次利用价值，如建筑垃圾类，生活垃圾类等。一般采取填埋、焚烧、卫生分解等方法处理，部分还可以使用生物解决，如放蚯蚓等。
		</view>
		<view class="text">
			●纸类、塑料类、玻璃类、金属类废弃物中不可回收的部分：如餐巾纸、卫生间用纸、尿不湿、狗尿垫、污损纸张、污损塑料、防碎气泡膜、一次性饭盒、带胶制品、镜子等。
		</view>
		<view class="text">
			●纺织类、木竹类废弃物中不可回收的部分：如拖把、抹布、竹制品、一次性筷子、树枝、尼龙制品、旧毛巾、内衣裤等。
		</view>
		<view class="text">
			●灰土类、砖瓦陶瓷类废弃物、其他混合垃圾：如猫砂、烟蒂、大骨头、硬贝壳、硬果实、毛发、灰土、炉渣、橡皮泥、太空沙、陶瓷花盆、陶瓷制品、成分复杂的制品等。
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
			
		}
	}
</script>
<style scoped lang="scss">
.body{
	// height: 100vh;
	background-color: #e8e5e2;
	padding-bottom: 50px;
	.pic{
		text-align: center;
		padding: 50px 0px;
		border-bottom: 3px dotted #71706e;
	}
	.title{
		font-size: 22px;
		font-weight: 700;
		padding: 0 40px;
		margin-top: 30px;
		color: #71706e;
	}
	.text{
		font-size: 17px;
		padding: 0 40px;
		margin-top: 15px;
		color: #71706e;
	}
}
</style>
