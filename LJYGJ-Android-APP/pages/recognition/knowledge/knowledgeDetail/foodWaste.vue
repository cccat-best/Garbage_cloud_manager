<template>
	<view class="body">
		<view class="pic">
			<image
				src="@/static/3.png" 
				mode="scaleToFill"
				style="width: 200px;height: 200px;border-radius: 20px;"
			></image>
		</view>
		<view class="title">
			厨余垃圾:
		</view>
		<view class="text">
			厨余垃圾即易腐垃圾，指食材废料、剩菜剩饭、瓜皮果核、中药药渣等易腐的生物质生活废弃物。这类垃圾是居民日常生活及食品加工、饮食服务、单位供餐等活动中产生的垃圾，其主要来源为家庭厨房、餐厅、饭店、食堂、市场及其他与食品加工有关的行业。
		</view>
		<view class="text">
			●食物废料：谷物及其加工食品、肉蛋及其加工食品、水产及其加工食品、蔬菜、调料、酱料等。
		</view>
		<view class="text">
			●剩饭剩菜：火锅汤底、鱼骨、碎骨、茶叶渣、咖啡渣、中药药渣等（蛤蜊壳、粽子叶、猪棒骨等属于干垃圾）。
		</view>
		<view class="text">
			●过期食品：糕饼、糖果、风干食品、粉末类食品、宠物饲料等。
		</view>
		<view class="text">
			●瓜皮果核:果肉、果皮、果核、水果茎枝、果实等。
		</view>
		<view class="text">
			●花卉植物：家养绿植、花卉、枝叶等。
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
	// height: 100vh;e0eaf6
	background-color: #e0eaf6;
	padding-bottom: 50px;
	.pic{
		text-align: center;
		padding: 50px 0px;
		border-bottom: 3px dotted #3e7a8c;
	}
	.title{
		font-size: 22px;
		font-weight: 700;
		padding: 0 40px;
		margin-top: 30px;
		color: #3e7a8c;
	}
	.text{
		font-size: 17px;
		padding: 0 40px;
		margin-top: 15px;
		color: #3e7a8c;
	}
}
</style>
