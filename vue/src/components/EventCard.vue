<template>
      <b-col class="col-md-5 col-lg-3">
        <div class="card-sl">
          <div class="card-image">
            <img v-bind:src="getImageURL(event.imageName)" alt="Event Image" />
          </div>
            <!-- <a class="card-action" href="#"><i class="fa fa-heart"></i></a> -->
          <div class="card-heading">{{ event.eventName }}</div>
          <div class="event-dates"> {{ event.startDate | formatDate }} - {{ event.endDate | formatDate }}</div>
          <div class="card-text">
            {{ event.description }}
          </div>
          <ul class="card-list">
            <li>Community Goal: {{ event.totalActivityGoal }} miles</li>
            <li>Individual Goal: {{ event.userActivityGoal }} miles</li>
          </ul>
          <div class="icons">
            <i v-if="containsRunning" class="fas fa-running fa-2x"></i>
            <i v-if="containsWalking" class="fas fa-walking fa-2x"></i>
            <i v-if="containsCycling" class="fas fa-biking fa-2x"></i>
            <i v-if="containsSwimming" class="fas fa-swimmer fa-2x"></i>
            <i v-if="containsOther" class="fas fa-asterisk fa-2x"></i>
          </div>  
          <a class="card-button" v-on:click="viewEventDetails(event.eventId)">View Details</a>
          <a class="signup-button" v-on:click.prevent="EventDetail.addEventToUser">Sign Up</a>
        </div>
      </b-col>  

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
.icons{
  text-align: center;
  background: #edf0db;
}

b-col {
  background-color:#e6e6e6
}

/*  Helper Styles */
    body {
        font-family: 'Montserrat', sans-serif;
        color: #505170;
        background-color: #e6e6e6
    }

    a {
        text-decoration: none;
    }

    .col-md-5 .col-lg-3 {
      background: red;
      border: none;
    }
/* Card Styles */
    .card-sl {
        margin: 2%;
        border-radius: 8px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        background: #edf0db;
    }
    .card-image img {
       width: 100%;
       height: auto;
        border-radius: 8px 8px 0px 0;
    }
    .card-action {
        position: relative;
        float: right;
        margin-top: -25px;
        margin-right: 20px;
        z-index: 2;
        color: #E26D5C;
        background: #fff;
        border-radius: 100%;
        padding: 15px;
        font-size: 15px;
        box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.2), 0 1px 2px 0 rgba(0, 0, 0, 0.19);
    }
    .card-action:hover {
        color: #fff;
        background: #E26D5C;
        -webkit-animation: pulse 1.5s infinite;
    }
    .card-heading {
        font-size: 22px;
        font-weight: bold;
        background: #edf0db;
        padding: 10px 15px;
    }
    .event-dates {
        padding: 0px 15px;
        background: #edf0db;
        font-size: 14px;
        font-style:italic;
        color: #636262;

    }
    .card-text {
        padding: 10px 15px;
        background: #edf0db;
        font-size: 14px;
        color: #636262;
    }
   .card-list {
    margin-left: 7%;
    background: #edf0db;
    }
    .card-button {
        display: flex;
        justify-content: center;
        padding: 10px 0;
        width: 100%;
        background-color: #Cfe6e0;
        color: #505170;
        font-weight: bold;
    }
    .signup-button {
        display: flex;
        justify-content: center;
        padding: 10px 0;
        width: 100%;
        background-color: #F16120;
        color: #edf0db;
        border-radius: 0 0 8px 8px;
    }

    .card-button:hover {
        text-decoration: none;
        background-color: #505170;
        color: #edf0db;
        font-weight: normal;
    }
    .signup-button:hover {
        text-decoration: none;
        background-color: #505170;
        color: #edf0db;
        font-weight: normal;
    }
    


    @-webkit-keyframes pulse {
        0% {
            -moz-transform: scale(0.9);
            -ms-transform: scale(0.9);
            -webkit-transform: scale(0.9);
            transform: scale(0.9);
        }

        70% {
            -moz-transform: scale(1);
            -ms-transform: scale(1);
            -webkit-transform: scale(1);
            transform: scale(1);
            box-shadow: 0 0 0 50px rgba(90, 153, 212, 0);
        }

        100% {
            -moz-transform: scale(0.9);
            -ms-transform: scale(0.9);
            -webkit-transform: scale(0.9);
            transform: scale(0.9);
            box-shadow: 0 0 0 0 rgba(90, 153, 212, 0);
        }
    }


</style>
