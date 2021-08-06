<template>
<div class="heroImage">
	<div class="heroContents">
		<h1>{{event.eventName}}</h1>
		<p>{{event.description}}</p>
        <h2>Activity Types</h2>
        <p id="activity" v-for="activity in event.activityType" v-bind:key="activity">{{activity}}</p>
        <p>Individual Activity Goal: {{event.userActivityGoal}} miles. Total Event Activity Goal: {{event.totalActivityGoal}} miles</p>
        <p>Start Date: {{event.startDate}} End Date: {{event.endDate}}</p>
		<button class="bookButton" v-if="$store.state.token != ''" v-on:click.prevent="addEventToUser">Register For Event</button>
        <p> {{logMessage}} </p>
	</div>
</div>
  <!-- <div>
      <h1>{{event.eventName}}</h1>
      <p>{{event.description}}</p>
      <h2>Activity Types</h2>
      <p id="activity" v-for="activity in event.activityType" v-bind:key="activity">{{activity}}</p>

      <p class="date">Start Date: {{event.startDate}}</p>
      <p class="date">End Date: {{event.endDate}}</p>

      <p>Individual Activity Goal: {{event.userActivityGoal}} miles</p>
      <p>Total Event Activity Goal: {{event.totalActivityGoal}} miles</p>

      <button v-if="$store.state.token != ''" v-on:click.prevent="addEventToUser">Register for this Event</button>
      <p> {{logMessage}} </p>
  </div> -->
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

        logMessage: ""
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
      eventService.addUserToEvent(this.event).then(response => {
         if (response.status == 201) {
                  this.logMessage = "Success signing up for your Event!";
              }
          }).catch(error => {
              this.handleErrorResponse(error);
      });
    },

    handleErrorResponse(error) {
        if (error.response) {
            this.logMessage = "Error adding a new activity. Error: " + error.response.status;
        }
        else if (error.request) {
               this.logMessage = "Error adding a new activity. Server unavailable, Error: " + error.status;
        }
        else {
            this.logMessage = "Java Green has left you high and dry. Pick better developers next time!";
        }
      }
  }

}
</script>

<style scoped>
* {
font-family: 'Montserat', sans-serif;
}
.heroImage {
	background: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.9)), url(../assets/photos/event_1.jpg);
	height: 50%;
	background-position: center;
	background-repeat: no-repeat;
	position: relative;
}

.heroContents {
	padding-top: 25px;
	text-align: center;
	color: white;
}

.bookButton {
  background-color: #f16120;
  border: none;
  color: white;
  padding: 10px;
  font-size: 15px;
  border-radius: 10px;
}
</style>