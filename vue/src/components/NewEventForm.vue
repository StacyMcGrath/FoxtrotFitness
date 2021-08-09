<template>
  <div>
    <div v-show="logMessage != ''">{{this.logMessage}}</div>  
   <form v-on:submit.prevent="submitForm" class="eventForm">
 
     <h1 class="form-header">Create New Event</h1>

      <div class="form-eventName">
        <label for="eventName">Event Name: </label>
        <input id="eventName" type="text" class="form-control" placeholder="Event Name" v-model="event.eventName" />
      </div>

      <div class="form-description">
        <label for="description">Short Description: </label>
        <input id="description" type="text" class="form-control" placeholder="1000 Characters Max" v-model="event.description" />
      </div>

      <div class="form-longDescription">
        <label for="longDescription">Long Description: </label>
        <input id="longDescription" type="text" class="form-control" placeholder="5000 Characters Max" v-model="event.longDescription" />
      </div>

      <div class="form-activity">
        <label for="activityType">Activity: </label>
        <select class="form-control" id="activityType" multiple v-model="event.activityType">
          <option disabled value="">Choose Activity</option>
            <option>Running</option>
            <option>Walking</option>
            <option>Cycling</option>
            <option>Swimming</option>
            <option>Other</option>
        </select>
      </div>

      <div class="form-date">
        <label for="startDate">Start Date: </label>
        <input id="startDate" type="date" class="form-control" placeholder="yyyy-mm-dd" v-model="event.startDate" />
      </div>

      <div class="form-date">
        <label for="endDate">End Date: </label>
        <input id="endDate" type="date" class="form-control" placeholder="yyyy-mm-dd" v-model="event.endDate" />
      </div>

     <div class="form-distance">
        <label for="userDistance">Individual Distance Goal: </label>
        <input id="userDistance" type="text" class="form-control" placeholder="Miles" v-model="event.userActivityGoal" />
      </div>

      <div class="form-distance">
        <label for="totalDistance">Total Distance Goal: </label>
        <input id="totalDistance" type="text" class="form-control" placeholder="Miles" v-model="event.totalActivityGoal" />
      </div>

      <button class="btn btn-submit">Submit</button>
      <button class="btn btn-cancel" type="reset" v-on:click.prevent="clearForm">Clear</button>
    </form>

  </div>
</template>

<script>
import eventService from '../services/EventService.js'

export default {
    name: "new-event-form",
data() {
    return {
        event: {
            eventId: null,
            eventName: "",
            description: "",
            longDescription: "",
            activityType: [],
            startDate: "",
            endDate: "",
            userActivityGoal: null,
            totalActivityGoal: null,
            imageName: ""
        },
        logMessage: ""

    };
 },  
methods: {
submitForm() {

          eventService.addNewEvent(this.event).then(response => {
              if (response.status == 201) {
                  this.$router.go();
                  this.logMessage = "Success adding your Event!";
              }
          }).catch(error => {
              this.handleErrorResponse(error);
          });
      },

handleErrorResponse(error) {
        if (error.response) {
            this.logMessage = "Error adding a new Event. Error: " + error.response.status;
        }
        else if (error.request) {
               this.logMessage = "Error adding a new Event. Server unavailable, Error: " + error.status;
        }
        else {
            this.logMessage = "Java Green has left you high and dry. Pick better developers next time!";
        }
      },
   clearForm() {
     this.event = {
            eventName: "",
            description: "",
            longDescription: "",
            activityType: [],
            startDate: "",
            endDate: "",
            userActivityGoal: null,
            totalActivityGoal: null,
        }
   }
 }
}

</script>

<style>

</style>