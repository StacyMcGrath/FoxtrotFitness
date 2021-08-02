<template>
  <div>
      <h1>{{event.eventName}}</h1>
      <p>{{event.description}}</p>
      <h2>Activity Types</h2>
      <p id="activity" v-for="activity in event.activityType" v-bind:key="activity">{{activity}}</p>

      <p class="date">Start Date: {{event.startDate}}</p>
      <p class="date">End Date: {{event.endDate}}</p>

      <p>Individual Activity Goal: {{event.userActivityGoal}} miles</p>
      <p>Total Event Activity Goal: {{event.totalActivityGoal}} miles</p>


  </div>
</template>

<script>
import eventService from '../services/EventService.js'
export default {
    name: "event-detail",
    data() {
      return{
        event: {
            eventId: null,
            eventName: "",
            description: "" ,
            activityType: [],
            startDate: "", 
            endDate: "",
            userActivityGoal: null,
            totalActivityGoal: null
        },
      };
    },

    created() {
    eventService.retrieveEventById(this.$route.params.eventId).then(response => {
        this.event = response.data;
    }
    );
  }

}
</script>

<style scoped>

.date {
    color: black;
}

</style>