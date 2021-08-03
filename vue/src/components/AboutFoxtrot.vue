<template>
<div>
  <div class="container">
  <img class="bgimg-1" src="../assets/oscar-aguilar-elias-Ku8MDO-FcaY-unsplash.jpg">
  <h4 class="top-left">Foxtrot Fitness Tracker</h4>

</div>

  
</div>
</template>

<script>
export default {
  name: 'about-foxtrot',

}
</script>

<style>


body, html {
  height: 100%;
  line-height: 1.8;
}

/* Full height image header */
.bgimg-1 {
  background-position: center;
  background-size: cover;
  margin-top: 20px;
  width: 100%;
  height: auto;
}


.container {
  position: relative;
  text-align: center;
  color: white;
}

/* Bottom left text */
.bottom-left {
  color: black;
  position: absolute;
  bottom: 8px;
  left: 16px;
}

/* Top left text */
.top-left {
  font-family: "Raleway", sans-serif;
  color: black;
  font-size: 32px;
  position: absolute;
  top: 40px;
  left: 40px;
}

/* Top right text */
.top-right {
  color: black;
  position: absolute;
  top: 8px;
  right: 16px;
}

/* Bottom right text */
.bottom-right {
  color: black;
  position: absolute;
  bottom: 8px;
  right: 16px;
}

/* Centered text */
.centered {
  color: black;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}


</style>