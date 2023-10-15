<template>
  <view>
    <view class="result">
      <view>
        <image
          src="../../../static/rubbish.png"
          mode="scaleToFill"
          style="width: 100vw; height: 300px"
        >
        </image>
        <view class="text"> 请扫描垃圾桶上的二维码，查看详情信息 </view>
      </view>
    </view>
    <view class="btn">
      <view class="pic" @click="scan"> 点击扫描 </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    scan() {
      uni.scanCode({
        success: (res) => {
          console.log(res);
          const msg = (res.result || "").split("")[7];
          //   console.log(res);
          //扫描成功后做一些验证
          //然后跳转
          uni.navigateTo({
            url: "/pages/recognition/details/detail?garbageId=" + msg,
          });
        },
      });
    },
  },
  onLaunch() {},
};
</script>

<style scoped lang="scss">
.btn {
  // background-color: orange;
  position: fixed;
  bottom: 20vh;
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
    box-shadow: 0 0 5px #d4d7de;
  }
}
.result {
  // background-color: firebrick;
  height: 50vh;
  margin-top: 70px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.text {
  text-align: center;
  margin-top: 30px;
  font-size: 20px;
  color: #606266;
}
</style>
