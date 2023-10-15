<template>
  <view class="content">
    <Lyn4ever-gaodeRoutePlanning :Config="config"/>
  </view>
</template>

<script>
export default {
  data() {
    return {
      config: {
        showMarks: true,
        lineColor: "#1B9B35",
        lineWidth: 10,
      },
    };
  },
  onLoad() {},
  computed: {},
  methods: {},
};
</script>
<style lang="scss" scoped>
</style>