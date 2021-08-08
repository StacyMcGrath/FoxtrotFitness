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


      <button class="btn btn-submit">Submit</button>
      <button class="btn btn-cancel" type="reset" v-on:click.prevent="clearForm">Clear</button>
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
            distance: ""
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
.form-header {
  grid-area: header;

}
.btn-submit{
  margin: 5px;
  width: 100px;
  grid-area: submit;
}
.btn-cancel{
  margin: 5px;
  width: 100px;
  grid-area: cancel;
}
form {
  display: grid;
  padding: 20px 15%;
  background: rgb(111, 139, 148);
  font-family: Arial, Helvetica, sans-serif;
  /* margin-top: 20px; */
  grid-template-columns:2fr 2fr 2fr 1fr 1fr ;
  grid-template-areas:
  "header header header header header"
  "date activity distance submit cancel";

}

.form-control {
  width: 50%;
  height: 30px;
}

label {

font-style: normal;
font-weight: bold;
font-size: 18px;
line-height: 36px;
}

</style>