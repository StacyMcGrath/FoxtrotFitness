<template>


<div class="w3-container" v-bind:key="event.eventId">
  

  <div class="w3-card-4" v-on:click="viewEventDetails(event.eventId)">
    <h2>{{ event.eventName }}</h2>
    <img class="event_photo" v-bind:src="getImageURL(event.imageName)" alt="Event Image">

    <div class="w3-container-text w3-center">
      <p>{{ event.description }}</p>
      <i v-if="containsRunning" class="fas fa-running fa-2x"></i>
      <i v-if="containsWalking" class="fas fa-walking fa-2x"></i>
      <i v-if="containsCycling" class="fas fa-biking fa-2x"></i>
      <i v-if="containsSwimming" class="fas fa-swimmer fa-2x"></i>
      <i v-if="containsOther" class="fas fa-asterisk fa-2x"></i>
    </div>
  </div>
</div>

</template>

<script>
export default {
name: "event-card",
props: ['event'],


computed: {
  containsRunning() {
    let containsRunning = false;
    if(this.event.activityType.includes("Running")){
      containsRunning = true;
    }
    return containsRunning;
  },
    containsWalking() {
    let containsWalking = false;
    if(this.event.activityType.includes("Walking")){
      containsWalking = true;
    }
    return containsWalking;
  },
    containsCycling() {
    let containsCycling = false;
    if(this.event.activityType.includes("Cycling")){
      containsCycling = true;
    }
    return containsCycling;
  },
    containsSwimming() {
    let containsSwimming = false;
    if(this.event.activityType.includes("Swimming")){
      containsSwimming = true;
    }
    return containsSwimming;
  },
    containsOther() {
    let containsOther = false;
    if(this.event.activityType.includes("Other")){
      containsOther = true;
    }
    return containsOther;
  },
},


  methods: {
     getImageURL(pic) {
        return require('../assets/photos/' + pic);
      },
      viewEventDetails(eventId) {
        this.$router.push(`/events/${eventId}`);
      }
  },

}
</script>

<style>

i {
    margin: 2%;
    color: #505170;
}

.w3-container {
    width:25%;
    font-family: 'Montserat' sans-serif;
   
    margin: 2%
}
.w3-card-4 {
    width:100%;
}

 .event_photo {
     width:100%;
     height: auto;
 }

 .w3-container-text {
    width:100%;
    font-family: 'Montserat' sans-serif;
    
}


</style>