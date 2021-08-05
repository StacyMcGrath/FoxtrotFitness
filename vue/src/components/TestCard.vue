<template>


<div class="w3-container" v-bind:key="event.eventId">
  

  <div class="w3-card-4">
    <h2>{{ event.eventName }}</h2>
    <img class="event_photo" src="../assets/photos/runner1.jpg" alt="Runner">
    <div class="w3-container-text w3-center">
      <p>{{ event.description }}</p>
      <i class="fas fa-running fa-2x"></i>
      <i class="fas fa-walking fa-2x"></i>
      <i class="fas fa-biking fa-2x"></i>
      <i class="fas fa-swimmer fa-2x"></i>
      <i class="fas fa-asterisk fa-2x"></i>
    </div>
  </div>
</div>

</template>

<script>
export default {
name: "test-card",
props: ['event'],

// data() {
//       return{
//         event: {
//             eventId: null,
//             eventName: "",
//             description: "" ,
//             activityType: [],
//             startDate: "", 
//             endDate: "",
//             userActivityGoal: null,
//             totalActivityGoal: null
//         }
//       };
//     }
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