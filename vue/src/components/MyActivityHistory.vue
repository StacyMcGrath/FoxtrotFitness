<template>
  <div>
      <img src="..\assets\activities.jpg" alt="Image of Activity">
      <h1>My Activity History</h1>
      <ul>
        <li v-for="activity in activities" v-bind:key="activity.activityId">Date: {{activity.activityDate}} {{activity.activityType}}: {{activity.distance}} miles | Time: {{activity.numberOfMinutes}} minutes</li>
      </ul>
      
  </div>
</template>

<script>
import activityService from '../services/ActivityService.js'
export default {
  name: "my-activity-history",
  data() {
    return {
      activities: []
      
    };

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

img {
    height: 150px;
    width: auto;
}
</style>