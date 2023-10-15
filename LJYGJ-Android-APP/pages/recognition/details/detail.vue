<template>
  <view class="all">
    <view class="noSearch" v-if="!trashList.length">
      <view>
        <image src="../../../static/none.png" mode="aspectFill"></image>
        <view class="text"> 暂时木有内容呀~~ </view>
      </view>
    </view>
    <view class="card-box" v-for="(item, index) in trashList" :key="index">
      <view class="card">
        <image :src="item.url" alt="" style="height: 100%" />
        <image
          src="../../../static/1.png"
          v-if="item.type === 1"
          alt=""
          style="height: 100%"
        />
        <image
          src="../../../static/2.png"
          v-if="item.type === 3"
          alt=""
          style="height: 100%"
        />
        <image
          src="../../../static/3.png"
          v-if="item.type === 4"
          alt=""
          style="height: 100%"
        />
        <image
          src="../../../static/4.png"
          v-if="item.type === 2"
          alt=""
          style="height: 100%"
        />
      </view>
    </view>
  </view>
</template>

<script>
export default {
  onLoad(options) {
    this.garbageId = options.garbageId;
  },
  onPullDownRefresh() {
    setTimeout(() => {
      uni.stopPullDownRefresh();
    }, 1000);
    this.getList();
  },
  data() {
    return {
      garbageId: "",
      trashList: [],
      type: [
        "@/static/1.png",
        "@/static/4.png",
        "@/static/2.png",
        "@/static/3.png",
      ],
    };
  },
  mounted() {
    this.getList();
  },
  methods: {
    getList() {
      uni.request({
        url:
          "https://rmb.sipcoj.com/garbage/info?garbageId=" +
          this.garbageId,
        method: "GET",
        header: {
          "content-type": "application/json",
        },
        success: (res) => {
          if (res.data.code !== "00000") {
            return;
          }
          this.trashList = res.data.data.recordPoList;
          console.log(res.data);
        },
      });
    },
  },
};
</script>

<style scoped lang="scss">
.all {
  min-height: 100vh;
  background-color: #f3f3f3;
  display: flex;
  flex-direction: column;
  align-items: center;
  .card-box {
    box-sizing: border-box;
    padding: 10px;
    width: 100%;
    height: 160px;
    .card {
      box-sizing: border-box;
      display: flex;
      justify-content: space-around;
      align-items: center;
      width: 100%;
      height: 100%;
      border-radius: 10px;
      background-color: #fff;
      padding: 10px;
    }
  }
}
.noSearch {
  height: 50vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 50px;
  .text {
    text-align: center;
    margin-top: 30px;
    font-size: 20px;
    color: #606266;
  }
}
</style>