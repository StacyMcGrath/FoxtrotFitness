<template>
<div>
    <div class="event-detail">
            <img class="bg" id="event-image" v-bind:src="getImageURL(event.imageName)" alt="Event Image">
            <h1 id="event-name">{{event.eventName}}</h1>  
            <div id="event-details">
                <ul>  
                    <li>Start Date: {{event.startDate | formatDate}}</li>
                    <li>End Date: {{event.endDate | formatDate}}</li>
                    <li>Individual Activity Goal: {{event.userActivityGoal}} miles.</li> 
                    <li>Total Community Goal: {{event.totalActivityGoal}} miles</li>
                </ul>
            </div>
            <div id="event-description">
                <p>{{event.longDescription}}</p><br>
                </div>
            <div id="event-activities">
                <h2>Activity Types</h2>
                <p id="activity" v-for="activity in event.activityType" v-bind:key="activity">{{activity}}</p>
            </div>
            <div id="register-button" v-show="!isUserSignedUp">
                <button class="bookButton" v-if="$store.state.token != ''" v-on:click.prevent="addEventToUser">Sign Up</button>
                <button class="bookButton" v-else v-on:click.prevent="$router.push(`/login`)">Sign Up</button>
                <p> {{logMessage}} </p>
            </div>
    </div>   
<group-progress v-show="isUserSignedUp"/>
<individual-progress v-show="isUserSignedUp"/>
<event-leaderboard v-show="isUserSignedUp"/>
    
</div>

</template>



<script>
import eventService from '../services/EventService.js'
import GroupProgress from '../components/GroupProgress.vue'
import IndividualProgress from '../components/IndividualProgress.vue'
import EventLeaderboard from '../components/EventLeaderboard.vue'
export default {
    name: "event-detail",
    components: {
        GroupProgress, IndividualProgress, EventLeaderboard
    },
    props: {
        progress: {
            default: 0,
            type: Number
        },
    },
    data() {
      return{
        events: [],
        event: {
        },
        logMessage: "",
        currentProgress: 0,
        
      };
    },

    created() {
    eventService.retrieveEventById(this.$route.params.eventId).then(response => {
        this.event = response.data;
    }
    );
    eventService.retrieveEventsByUser().then(response => {
            this.events = response.data;
    }
    );
  },

  methods: {
    getImageURL(pic) {
        return require('../assets/photos/' + pic);
      },
    addEventToUser() {
      eventService.addUserToEvent(this.event).then(response => {
         if (response.status == 201) {
                this.$router.go();
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
      },

  },
  computed: {
    isUserSignedUp() {
        let isUserSignedUp = false;
        this.events.forEach(event => {
            if(event.eventId == this.$route.params.eventId){
            isUserSignedUp = true;
                } 
            });
        return isUserSignedUp;
    }
  }
}
</script>

<style scoped>

.event-detail {
    border: solid #505170 .5px;
    border-radius: 10px;
    width: 90%;
    margin:auto;
    margin-top: 2%;
    padding: 0.5%;
    font-family: 'Montserrat', sans-serif;
    background-color: #edf0db;
    color: #505170;
    display: grid;
    grid-template-columns: 2fr 2fr 5fr;
    grid-template-areas:"name name image"
                        "details details image"
                        "description description image"
                        "activities button image";
    overflow: hidden;
    position: relative;
    
}
.container {
    width: 90%;
    margin: auto;
}
.bg {
  /* Full height */
  width: 100%;
  height: auto;
  border-radius: 10px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
} 

#event-image {
    grid-area: image;
    background-color: #edf0db;
}
#event-name {
    grid-area: name;
}
#event-description {
    grid-area: description;
    background-color: #edf0db;
}
#event-activities {
    grid-area: activities;
    background-color: #edf0db;
}
#event-details {
    grid-area: details;
    background-color: #edf0db;
}
#register-button {
    grid-area: button;
    background-color: #edf0db;
}
#activity {
    line-height: 0;
    margin-left: 15%;
}


h1 {
    font-size: 40px;
    padding: 0;
    margin: 0;
}
h2 {
    font-size: 20px;
    text-decoration: underline;
    padding: 0;
    margin-top: 0;
    margin-bottom: 10px;
    margin-left: 15%;
}
p {
    padding: 0;
    margin-top: 1%;
    font-size:14px;
}
ul {
    padding: 0;
    margin-top: 2%;
    margin-left: 7%;
}

.bookButton {
  background-color: #f16120;
  border: none;
  color: #edf0db;
  width: 90%;
  margin-bottom: 10%;
  padding: 15px;
  font-size: 15px;
  border-radius: 10px;
}
.progress-title{
    font-size: 18px;
    font-weight: 700;
    color: #505170;
    text-transform: uppercase;
    margin: 25px 0 25px;
}
.progress{
    height: 10px;
    background: #e9e9ea;
    border-radius: 15px;
    margin-bottom: 30px;
    overflow: visible;
    position: relative;
}
.progress:before,
.progress:after{
    content: "";
    width: 20px;
    height: 20px;
    border-radius: 50%;
    background: #fff;
    position: absolute;
    top: -5px;
    left: 0;
    z-index: 1;
}
.progress:after{
    border: 7px solid #e9e9ea;
    left: auto;
    right: 0;
}
.progress .progress-bar{
    box-shadow: none;
    border: none;
    border-radius: 15px;
    position: relative;
    -webkit-animation: animate-positive 1s;
    animation: animate-positive 1s;
}
.progress .progress-value{
    width: 70px;
    height: 35px;
    line-height: 27px;
    border-radius: 20px;
    background: #fff;
    font-size: 17px;
    font-weight: 600;
    position: absolute;
    top: -12px;
    right: 0;
    z-index: 2;
}
.progress.orange:before{ border: 7px solid #fe3b3b; }
.progress.blue:before{ border: 7px solid #1a4966; }
.progress.green:before{ border: 7px solid #B6d44a; }
.progress.purple:before{ border: 7px solid #66406f; }
.progress.orange .progress-value{
    border: 5px solid #fe3b3b;
    color: #fe3b3b;
}
.progress.blue .progress-value{
    border: 5px solid #1a4966;
    color: #1a4966;
}
.progress.green .progress-value{
    border: 5px solid #B6d44a;;
    color: #B6d44a;;
}
.progress.purple .progress-value{
    border: 5px solid #66406f;
    color: #66406f;
}
@-webkit-keyframes animate-positive{
    0%{ width: 0; }
}
@keyframes animate-positive{
    0%{ width: 0; }
}

</style>