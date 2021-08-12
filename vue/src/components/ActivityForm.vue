<template>
  <div>
    <div v-show="logMessage != ''">{{this.logMessage}}</div>  
   <form v-on:submit.prevent="submitForm" class="activityForm">
     <h1 class="form-header">Log recent activity</h1>
     <div class="form-date">
        <label for="date">Date: </label>
        <input id="date" type="date" class="form-control" placeholder="yyyy-mm-dd" v-model="activity.activityDate" />
      </div>
            <div class="form-activity">
        <label for="activityType">Activity: </label>
        <select class="form-control" v-model="activity.activityTypeId">
          <option disabled value="">Choose Activity</option>
            <option value=1>Running</option>
            <option value=2>Walking</option>
            <option value=3>Cycling</option>
            <option value=4>Swimming</option>
            <option value=5>Other</option>
        </select>

      </div>
           <div class="form-distance">
        <label for="distance">Distance: </label>
        <input id="distance" type="text" class="form-control" placeholder="Miles" v-model="activity.distance" />
      </div>

      <div class="form-number-of-minutes">
        <label for="number-of-minutes">Time: </label>
        <input id="number-of-minutes" type="text" class="form-control" placeholder="Minutes" v-model="activity.numberOfMinutes" />
      </div>

      <button class="btn btn-submit">Submit</button>
      <button class="btn btn-cancel" type="reset" v-on:click.prevent="clearForm">Clear Form</button>
    </form>

  </div>

</template>

<script>
import activityService from '../services/ActivityService.js'
export default {
name: "activity-form",
data() {
    return {
        activity: {
            activityId: null,
            userId: null,
            activityTypeId: null,
            activityDate: "",
            distance: "",
            numberOfMinutes: ""
        },
        logMessage: ""

    };

},

methods: {
submitForm() {

          activityService.logActivity(this.activity).then(response => {
              if (response.status == 201) {
                  this.$router.go();
                  this.logMessage = "Success logging your Activity!";
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
   clearForm() {
     this.activity = {
            activityId: null,
            userId: null,
            activityTypeId: null,
            activityDate: "",
            distance: ""};
   },
}
}



</script>



<style scoped>

.form-date {
  grid-area: date;
}
.form-activity {
  grid-area: activity;
}
.form-distance {
  grid-area: distance;
}
.form-number-of-minutes{
  grid-area: minutes;
}
.form-header {
  grid-area: header;

}
.btn-submit{
  grid-area: submit;
  background-color: #f16120;
  font-family: 'Montserrat', sans-serif;
  border: none;
  color: #edf0db;
  text-align: center;
  width: 50%;
  margin-top: 3%;
  margin-left: 20%;
  font-size: 15px;
  border-radius: 10px;
}
.btn-cancel{

  grid-area: cancel;
  background-color:edf0db;
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  text-align: center;
  align-content: center;
  width: 50%;
  margin-left: 20%;
  font-size: 15px;
  border-radius: 10px;

}
form {
  display: grid;
  padding: 2% 0% 5% 2%;
  background: #e6e6e6;
  font-family: 'Monserrat', sans-serif;
  grid-template-columns:1fr 1fr 1fr;
  grid-template-areas:
  "header header header"
  "date activity ." 
  "distance minutes ." 
  "submit submit ."
  "cancel cancel .";

}

.form-control {
  width: 80%;
  height: 35px;
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  }

label {
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  font-style: normal;
  font-weight: bold;
  font-size: 14px;
  line-height: 30px;
}
h1 {
  font-family: 'Montserrat', sans-serif;
  color: #505170;
  font-style: normal;
  font-weight: bold;
  font-size: 24px;
  line-height: 36px;
}

</style>