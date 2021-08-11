<template>
<div>
  <div class="container">
  <img class="bgimg-1" src="..\assets\Home Page Graphic.jpg">
  <h4 class="top-left">Your Goals + Community Events = FITNESS FUN</h4>
  <p>Keep your health and fitness on track by combining your personal goals with fun, virtual community events!</p>
</div>
<div class="screenshots">
<h3 id="p1">Log activities and see your events and goals on your personal dashboard</h3>
<img id="img1" src="..\assets\MyDashboard.png">
<img id="img2" src="..\assets\EventDetail.png">
<img id="img3" src="..\assets\MyGoalsHistory.png">
</div>
</div>
</template>

<script>
export default {
  name: 'about-foxtrot',

}
</script>

<style scoped>


body, html {
  height: 100%;
  line-height: 1.8;
}

/* Full height image header */
.bgimg-1 {
  background-position: center;
  background-size: cover;
  width: 100%;
  height: auto;
}

.container {
  position: relative;
  text-align: center;
  color: white;
}

/* Top left text */
.top-left {
  font-family: 'Montserrat', sans-serif;
  font-weight: bold;
  color: #505170;
  font-size: 40px;
  position: absolute;
  top: 20px;
  left: 40px;
}

p {
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  font-size: 24px;
  text-align: left;
  margin-right: 30%;
  position: absolute;
  top: 100px;
  left: 40px;
}

.screenshots {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "p1 . ."
                      "one two three";
  column-gap: 5%;
  margin: 5%;
  

}

#img1 {
  grid-area: one;
  width: 100%;
  height: auto;
  border: solid #505170 1px;
}

#img2 {
  grid-area: two;
  width: 100%;
  height: auto;
  border: solid #505170 1px;
}

#img3 {
  grid-area: three;
  width: 100%;
  height: auto;
  border: solid #505170 1px;
}

#p1 {
  grid-area: p1;
}


</style>