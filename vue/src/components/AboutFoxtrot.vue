<template>
<div id="homepage">
  <div id="homepage image">
  <img class="bgimg-1" src="..\assets\Home Page Graphic.jpg">
  <h4 class="top-left">An Active Community in a Virtual World</h4>
  <p>Keep your health and fitness on track by combining your personal goals with fun, virtual community events!</p>
</div>

    <button id="actionbutton" v-on:click="$router.push({name: 'register'})">Take the first step</button>

<div>
  <carousel-3d :width="400" :height="280" :autoplay="true" :autoplay-timeout="2000">
    <slide :index="0">
        <figure>
        <img :width="400" id="img1" src="..\assets\Dashboard.png">
        <figcaption>
        Log in to see your personal dashboard, where you can log activities, track events and goals, and see your badges!
        </figcaption>
        </figure>
    </slide>
    <slide :index="1">
        <img id="img2" src="..\assets\activityhistory.png">
        <figcaption>
        View a complete history of all logged activities.
        </figcaption>
    </slide>
    <slide :index="3">
        <img id="img3" src="..\assets\createnewevent.png">
        <figcaption>
        Create a new virtual event to share with your friends! Select activity types, dates, and distance goals
        </figcaption>
    </slide>
    <slide :index="2">
        <img id="img4" src="..\assets\events.png">
        <figcaption>
        Browse a variety of fun virtual challenges, each with an individual goal and a collective community goal!
        </figcaption>
    </slide>
    <slide :index="4">
        <img id="img5" src="..\assets\progress.png">
        <figcaption>
        When you join an event, you'll see your progres, the group progres, and a leaderboard!
        </figcaption>
    </slide>
  </carousel-3d>
</div>


</div>
</template>

<script>
export default {
  name: 'about-foxtrot',

}
</script>

<style scoped>

figure {
  margin:0;
}

figcaption {
  position: absolute;
  background-color: #505170;
  color: #edf0db;
  bottom: 0;
  position: absolute;
  bottom: 0;
  padding: 15px;
  font-size: 12px;
  min-width: 100%;
  height: 55px;
  box-sizing: border-box;
}

div {
    width: 100%;
    height: auto;
    margin: 0px;
    padding: 0px;
    overflow-x: hidden; 
}

/* Full height image header */
.bgimg-1 {

  width: 100%;
  height: auto;
  margin: 0px;
  padding: 0px;
 
}


#homepage {
  padding: p-0;
   margin: 0px;
    padding: 0px;
  width: 100%;
  
}



/* Top left text */
.top-left {
  font-family: 'Montserrat', sans-serif;
  font-weight: bold;
  text-shadow: 2px 2px #b6d44a;
  color: #505170;
  font-size: 40px;
  position: absolute;
  top: 60px;
  left: 40px;
}

p {
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  font-size: 24px;
  text-align: left;
  margin-right: 30%;
  position: absolute;
  top: 130px;
  left: 40px;
}

#actionbutton {
  font-family: 'Montserrat', sans-serif;
  position: absolute;
  top: 220px;
  left: 40px;
  background: #f16120;
  color: #edf0db;
  font-weight: bold;
  font-size: 18px;
  border-radius: 10px;
  border: none;
  width: 300px;
  height: 40px;
  cursor: pointer;
  opacity: 1;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);

}

#actionbutton:hover {
  opacity: .8;
  color: white;

}


</style>