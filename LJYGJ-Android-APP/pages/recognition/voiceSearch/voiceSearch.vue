<!-- 语音识别，有时间加上 -->
<template>
	<view>
		<view class="result" v-if="show">
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
		<view class="noSearch" v-if="!show">
			<view>
				<image
					src="../../../static/none.png" 
					mode="aspectFill" 
					></image>
				<view class="text">
					{{text}}
				</view>
			</view>
		</view>
		<view class="btn">
			<view class="item">
				<view class="img" @click="voice">
					<image
						src="../../../static/voice.png" 
						style="width: 50px;height: 50px;"
						mode="scaleToFill" 
					></image>
				</view>
				<view class="tip">
					开始录音
				</view>
			</view>
			<view class="item">
				<view class="img" @click="lisen">
					<image
						src="../../../static/kefu.png" 
						style="width: 50px;height: 50px"
						mode="scaleToFill" 
					></image>
				</view>
				<view class="tip">
					试听录音
				</view>
			</view>
		</view>
		<view class="upload" @click="upload">
			上传识别
		</view>
	</view>
</template>

<script>
	const recorderManager = uni.getRecorderManager();
	const innerAudioContext = uni.createInnerAudioContext();
	export default {
		data() {
			return {
				show:false,
				src:'../../../static/4.png',
				text:'暂时木有内容',
				num:0,
				voicePath: '123',
				recorder: "",
				innerAudio:"",
				isVoice: false,
			}
		},
		methods: {
			voice(){
				this.isVoice = !this.isVoice;
				let format = {
				  format: "mp3",
				  duration: 10000,
				};
				if(this.isVoice){
					this.recorder.start(format);
					let self = this;
					uni.showToast({
					  title: "开始录音",
					  icon: "success",
					});
					this.recorder.onStop(function (res) {
					  self.voicePath = res.tempFilePath;
					});
				}
				if(!this.isVoice){
					this.recorder.stop();
					uni.showToast({
					  title: "录音结束",
					  icon: "success",
					});
				}
			},
			lisen(){
				console.log(this.voicePath)
				if (this.voicePath) {
				  this.innerAudio.src = this.voicePath;
				  this.innerAudio.play();
				} else {
				  uni.showToast({
				    title: "请先录制音频",
				    icon: "error",
				  });
				}
			},
			upload(){
				console.log('上传')
				
			}
		},
		onLoad() {
			let recorderManager = uni.getRecorderManager();
			let innerAudioContext = uni.createInnerAudioContext();
			this.recorder = recorderManager;
			this.innerAudio = innerAudioContext;
			this.recorder.start.format = "wav";
			this.recorder.start.duration = 10000;
			this.recorder.start.sampleRate = 44100;
		},
		onHide() {
		  this.innerAudio.pause();
		},
		onUnload() {
		  this.innerAudio.pause();
		  if (this.timer1) {
		    clearTimeout(this.timer1);
		    this.timer1 = null;
		  }
		  if (this.timer2) {
		    clearTimeout(this.timer2);
		    this.timer2 = null;
		  }
		},
	}
</script>

<style scoped lang="scss">
.noSearch{
	height: 50vh;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 50px;
}
.result{
	// background-color: firebrick;
	height: 50vh;
	margin-top: 70px;
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
.btn{
	position: absolute;
	bottom: 30vh;
	width: 100%;
	// background-color: orange;
	display: flex;
	justify-content: space-around;
	.item{
		.tip{
			// background-color: green;
			text-align: center;
			color: #606266;
			font-size: 15px
		}
		.img{
			// background-color: orchid;
			height: 60px;
			width: 60px;
			// border-radius: 45px;
			margin: 0 auto;
			// border: 1px solid #606266;
			// box-shadow: 0 0 5px #D4D7DE;
			display: flex;
			justify-content: center;
			align-items: center;
		}
	}
}
.upload{
	position: absolute;
	bottom: 20vh;
	color: #606266;
	font-size: 16px;
	width: 60%;
	text-align: center;
	// background-color: orchid;
	height: 40px;
	line-height: 40px;
	border-radius: 10px;
	margin-left: 20%;
	// border: 1px solid #606266;
	box-shadow: 0 0 5px #D4D7DE;
}
</style>

