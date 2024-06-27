function draw(option, notMerge) {
  window.viewport.setOption(option, notMerge);
}

window.onload = function() {
  window.viewport = echarts.init(document.getElementById('container'));
}