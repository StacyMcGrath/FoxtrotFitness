<template>
<div>
  <div class="container">
  <img class="bgimg-1" src="..\assets\Home Page Graphic.jpg">
  <h4 class="top-left">Personal Goals + Community Events = FITNESS FUN</h4>
  <p>Keep your fitness goals on track by combining your personal goals with fun, virtual community events!</p>

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




</style>