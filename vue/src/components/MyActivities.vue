<template>
  <div>
      <img src="..\assets\activities.jpg" alt="Image of Activity">
      <h1>My Activities</h1>
      <ul>
        <li v-for="activity in computedActivities" v-bind:key="activity.activityId">Date: {{activity.activityDate}} {{activity.activityType}}: {{activity.distance}} miles</li>
      </ul>
      <button>View All</button>
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

img {
    height: 150px;
    width: auto;
}
</style>