<template>
	<view class="all">
		<view class="search">
			<uni-search-bar
			placeholder="文字搜索识别" 
			v-model="searchValue"
			clearButton="auto" 
			cancelButton="auto"
			@confirm="search" />
		</view>
		<view class="result">
			<view>
				<image
					:src="src" 
					mode="scaleToFill"
					style="width: 300px;height: 300px;border-radius: 20px;"
					></image>
				<view class="text">
					{{text}}
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				searchValue:'',
				src:'../../../static/none.png',
				text:'暂时没有结果~'
			}
		},
		methods: {
			search(){
				uni.request({
				   url: 'https://rmb.sipcoj.com/user/c/search',
					method:"GET",
				   data: {
				       content:this.searchValue
				    },
				    header: {
				        "content-type":"application/json",
				    },
				    success: (res) => {
						if(res.data.code=='00000'){
							switch(res.data.data.type){
								case 1:
									this.text="此垃圾为可回收垃圾";
									this.src='../../../static/1.png';
									break
								case 2:
									this.text="此垃圾为其它垃圾";
									this.src='../../../static/4.png';
									break
								case 3:
									this.text="此垃圾为有害垃圾";
									this.src='../../../static/2.png';
									break
								case 4:
									this.text="此垃圾为厨余垃圾";
									this.src='../../../static/3.png';
									break
								case 0:
									this.text="暂时未检索到~";
									this.src='../../../static/none.png';
									break
							}
						} else {
							uni.showToast({
								title: res.data.message,
								icon:'error'
							});
						}
				    }
				});
			}
		}
	}
</script>

<style scoped lang="scss">
.search{
	width: 90%;
	margin: 0 auto;
	margin-top: 40px;
}
.result{
	height: 50vh;
	margin-top: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
}
.text{
	text-align: center;
	margin-top: 30px;
	font-size: 20px;
	color: #606266;
}
</style>
