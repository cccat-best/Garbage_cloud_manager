<template>
	<view class="body">
		<view class="pic">
			<image
				src="@/static/2.png" 
				mode="scaleToFill"
				style="width: 200px;height: 200px;border-radius: 20px;"
			></image>
		</view>
		<view class="title">
			有害垃圾:
		</view>
		<view class="text">
			有害垃圾是指存有对人体健康有害的重金属、有毒的物质或者对环境造成现实危害或者潜在危害的废弃物。它包括废电池、废油漆桶、废家电类、过期药品、过期化妆品等。有害有毒垃圾必须单独收集、运输、存贮，由环保部门认可的专业机构进行特殊安全处理。
		</view>
		<view class="text">
			●电池类:纽扣电池、充电电池（如手机电池）、铅酸电池、蓄电池等。不含普通干电池（如 1号、5号、7号电池，因具生产已达到国家低汞或无汞技术要求，现作为其他垃圾投放）。
		</view>
		<view class="text">
			●含汞类:废荧光灯管、废节能灯、废水银温度计、废水银血压计、 荧光棒、水银体温计、水银血压计等。
		</view>
		<view class="text">
			●费药类:过期药品、药片、过期胶囊药品、药品包装等。
		</view>
		<view class="text">
			●油漆、废农药类:废油漆桶、染发剂壳、洗甲水、过期指甲油、老鼠药、杀虫剂等。
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
	padding-bottom: 50px;
	background-color: #f9eae9;
	.pic{
		text-align: center;
		padding: 50px 0px;
		border-bottom: 3px dotted #b82424;
	}
	.title{
		font-size: 22px;
		font-weight: 700;
		padding: 0 40px;
		margin-top: 30px;
		color: #b82424;
	}
	.text{
		font-size: 17px;
		padding: 0 40px;
		margin-top: 15px;
		color: #b82424;
	}
}
</style>
