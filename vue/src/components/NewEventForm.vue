<template>
    <div class="container-fluid px-1 py-5 mx-auto">
    <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
            <div class="card">
                <h3>Create a New Event</h3>
                <div v-show="logMessage != ''">{{this.logMessage}}</div>
                <form class="form-card" v-on:submit.prevent="submitForm">
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-12 flex-column d-flex"> <label class="form-control-label px-3">Event Name<span class="text-danger"> *</span></label> <input type="text" id="eventName" name="eventName" placeholder="Enter Event Name" v-model="event.eventName"> </div>
                    </div>
                    <div class="row justify-content-between text-left">
                      <div class="form-group col-sm-6 flex-column d-flex">  
                          <label for="activityType">Activity: </label>
                            <select class="form-control" :select-size="5" id="activityType" multiple v-model="event.activityType">
                            <option disabled value="">Choose Activity</option>
                                <option>Running</option>
                                <option>Walking</option>
                                <option>Cycling</option>
                                <option>Swimming</option>
                                <option>Other</option>
                            </select>
                       </div>  

                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> 
                            <label class="form-control-label px-3">Start Date<span class="text-danger"> *</span></label> 
                            <input type="date" id="startDate" placeholder="" v-model="event.startDate" > 
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> 
                            <label class="form-control-label px-3">End Date<span class="text-danger"> *</span></label> 
                            <input type="date" id="endDate" placeholder="" v-model="event.endDate" > 
                        </div>

                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> 
                            <label class="form-control-label px-3">Individual Distance Goal: <span class="text-danger"> *</span></label> 
                            <input type="text" id="userDistance" placeholder="Miles" v-model="event.userActivityGoal" > 
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> 
                            <label class="form-control-label px-3">Community Distance Goal: <span class="text-danger"> *</span></label> 
                            <input type="text" id="totalDistance" placeholder="Miles" v-model="event.totalActivityGoal" > 
                        </div>

                    </div>

                    <div class="row justify-content-between text-left">
                        <div class="form-group col-12 flex-column d-flex"> 
                            <label class="form-control-label px-3">Enter a brief description:<span class="text-danger"> *</span></label>
                            <input type="text" id="description"  placeholder="" v-model="event.description">
                        </div>
                    </div>
                    <div class="row justify-content-end">
                        <div class="form-group col-sm-6"> <button type="submit" class="btn-block btn-primary">Submit New Event</button> </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
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
                  this.logMessage = "Success adding your Event!";
                  this.$router.push(`/events`);
              }
          }).catch(error => {
              this.handleErrorResponse(error);
          });
      },

handleErrorResponse(error) {
        if (error.response) {
            this.logMessage = "Error adding a new Event. Please fill in required fields & try again. Error: " + error.response.status;
        }
        else if (error.request) {
               this.logMessage = "Error adding a new Event. Please try again later, Server is currently unavailable, Error: " + error.status;
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

<style scoped>
.container-fluid {
    color: rgb(99, 86, 86);
    overflow-x: hidden;
    height: 100%;
    background-image: url("../assets/Home Page Graphic.jpg");
    background-repeat: no-repeat;
    background-size: 100% auto;
}

.card {
    padding: 30px 40px;
    margin-top: 60px;
    margin-bottom: 60px;
    border: none !important;
    background-color: #cfe6e0;
    box-shadow: 0 6px 12px 0 rgba(0, 0, 0, 0.2)
}

h3 {
    font-family: 'Montserrat', sans-serif;
    color: #f16120;
    font-size: 32px;
    font-weight: bold;
}

.form-control-label {
    margin-bottom: 0;
}
.form-control {
    background-color: #edf0db;
}

input,
textarea,
button {
    padding: 8px 15px;
    border-radius: 5px !important;
    margin: 5px 0px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    font-size: 18px !important;
    font-weight: 300;
    background-color: #edf0db;
    
}

input:focus,
textarea:focus {
    -moz-box-shadow: none !important;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    border: 1px solid #f16120;
    outline-width: 0;
    font-weight: 400
}


.btn-block {
   background-color: #f16120;
  font-family: 'Montserrat', sans-serif;
  border: none;
  color: #edf0db;
  text-align: center;
  width: 70%;
  margin-top: 3%;
  margin-left: 20%;
  font-size: 15px;
  border-radius: 10px;
}

.btn-block:hover {
    color: #fff !important
}

button:focus {
    -moz-box-shadow: none !important;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    outline-width: 0
}
</style>