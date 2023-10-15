<template>
	<view class="body">
		<view class="pic">
			<image
				src="@/static/1.png" 
				mode="scaleToFill"
				style="width: 200px;height: 200px;border-radius: 20px;"
			></image>
		</view>
		<view class="title">
			可回收物:
		</view>
		<view class="text">
			可回收物就是再生资源，指生活垃圾中未经污染、适宜回收循环利用的废物。 主要包括废弃电器电子产品、废纸张、废塑料、废玻璃、废金属等五类，是现阶段生活垃圾分类的主要工作和影响垃圾减量的重要因素。
		</view>
		<view class="text">
			●废纸主要包括：报纸、杂志、图书、各种包装纸、办公用纸、纸盒等，但是纸巾和卫生用纸由于水溶性太强不可回收
		</view>
		<view class="text">
			●塑料主要包括：各种塑料袋、塑料包装物和餐具、牙刷、杯子、矿泉水瓶、塑料玩具、塑料文具、塑料生活用品、洗发液瓶、洗手液瓶、洗衣液瓶、洗洁精瓶
		</view>
		<view class="text">
			●玻璃主要包括：玻璃饮料瓶、玻璃酒瓶、坏玻璃杯、碎玻璃窗、废玻璃板、镜片、镜子等，根据回收工艺，玻璃分为无色玻璃，绿色玻璃，棕色玻璃
		</view>
		<view class="text">
			●金属主要包括:易拉罐、金属罐头盒、装饰物、铝箔、铁片、铁钉、铁管、废铁丝、旧钢丝球、铜导线等，按照回收材料分类：铁类，非铁类(一般指有色金属)
		</view>
		<view class="text">
			●纺织物主要包括：废弃衣服、裤子、毛巾、书包、布鞋、床单、被褥、毛绒玩具等
		</view>
		<view class="text">
			●危害垃圾主要包括:油漆、颜料、各类清洗液等化学品，部分地区将电池和电子/电器垃圾也归于此类
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
	background-color: #bef1c8;
	padding-bottom: 50px;
	.pic{
		text-align: center;
		padding: 50px 0px;
		border-bottom: 3px dotted #4ba868;
	}
	.title{
		font-size: 22px;
		font-weight: 700;
		padding: 0 40px;
		margin-top: 30px;
		color: #2f6a40;
	}
	.text{
		font-size: 17px;
		padding: 0 40px;
		margin-top: 15px;
		color: #2f6a40;
	}
}
</style>
