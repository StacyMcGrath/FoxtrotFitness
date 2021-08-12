<template>
  <div>
      <img src="..\assets\MyActivities.png" alt="Image of Activity">
      
      <ul>
        <li v-for="activity in computedActivities" v-bind:key="activity.activityId">{{(activity.activityDate) | formatDate }} | {{activity.activityType}} | {{activity.distance.toLocaleString()}} mi. | {{activity.numberOfMinutes}} min.</li>
      </ul>
      <router-link id="viewall" v-bind:to="{name: 'my-activity-history'}">View All</router-link>
  </div>
</template>

<script>
import activityService from '../services/ActivityService.js'
export default {
  name: "my-activities",
  data() {
    return {
      activities: [],
      limit: 3
      
    };

  },
  computed: {
    computedActivities() {
      return this.limit ? this.activities.slice(0, this.limit) : this.activities
    }

  },
  methods: {
   
  },
  created() {
    activityService.retrieveActivitiesByUser().then(response => {
        this.activities = response.data;
  }
    )
}
}


</script>

<style scoped>

.activities {

font-family: Montserrat;
font-style: normal;
font-weight: 500;
font-size: 20px;
line-height: 18px;
letter-spacing: -0.015em;
width: 100%;
margin-left:0%;
}

ul {
   margin-left: 5%;
  line-height: 200%;
}

img {
    width: 80%;
    height: auto;
}

#viewall {
  font-size: 12px;
  margin-left: 43%;
  
}
</style>