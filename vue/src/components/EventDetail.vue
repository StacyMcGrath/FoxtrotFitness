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

      <button v-if="$store.state.token != ''" v-on:click="addEventToUser">Register for this Event</button>
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
        }
      };
    },

    created() {
    eventService.retrieveEventById(this.$route.params.eventId).then(response => {
        this.event = response.data;
    }
    );
  },

  methods: {
    addEventToUser() {
      eventService.addUserToEvent(this.event.eventId).then(response => {
         if (response.status == 201) {
                  this.logMessage = "Success signing up for your Event!";
              }
          }).catch(error => {
              this.handleErrorResponse(error);
      });
    }
  }

}
</script>

<style scoped>
div {
    margin-left: 20px;
}
.date {
    color: black;
}

</style>