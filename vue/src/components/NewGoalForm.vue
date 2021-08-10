<template>
    <div class="container-fluid px-1 py-5 mx-auto">
    <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
            <h3>Create a New Goal</h3>
            <p class="blue-text">Just answer a few questions<br> so that we can personalize the right experience for you.</p>
            <div class="card">
                <h5 class="text-center mb-4">Create a New Goal</h5>
                <div v-show="logMessage != ''">{{this.logMessage}}</div>
                <form class="form-card" v-on:submit.prevent="submitForm">
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-12 flex-column d-flex"> 
                            <label class="form-control-label px-3">Give your goal a name:<span class="text-danger"> *</span></label>
                            <input type="text" id="goalName" name="goalName" placeholder="" v-model="goal.goalName"> 
                        </div>
                    </div>
                    <div class="row justify-content-between text-left">
                      <div class="form-group col-sm-6 flex-column d-flex">  
                          <label for="activityType">Activity Type: </label>
                            <select class="form-control" id="activityType" multiple v-model="goal.activityType">
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
                            <input type="date" id="startDate" placeholder="" v-model="goal.startDate" > 
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> 
                            <label class="form-control-label px-3">End Date<span class="text-danger"> *</span></label> 
                            <input type="date" id="endDate" placeholder="" v-model="goal.endDate" > 
                        </div>

                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> 
                            <label class="form-control-label px-3">Activity Goal: <span class="text-danger"> *</span></label> 
                            <input type="text" id="userDistance" placeholder="Please enter a number" v-model="goal.activityGoal" > 
                        </div>
                        <div class="form-group col-sm-3 flex-column d-flex"> 
                            <input type="radio" id="miles" value="Miles" v-model="goal.activityUnits">
                            <label for="miles">Miles</label>
                        </div>
                        <div class="form-group col-sm-3 flex-column d-flex">
                            <input type="radio" id="minutes" value="Minutes" v-model="goal.activityUnits">
                            <label for="two">Minutes</label>   
                        </div>     
                    </div>
                    
                    <div class="row justify-content-end">
                        <div class="form-group col-sm-6"> <button type="submit" class="btn-block btn-primary">Create New Goal</button> </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

  
</template>

<script>
import goalService from '../services/GoalService.js'

export default {
    name: "new-goal-form",
data() {
    return {
        goal: {
        },
        logMessage: ""

    };
 },  
methods: {
submitForm() {

          goalService.addNewGoal(this.goal).then(response => {
              if (response.status == 201) {
                  this.logMessage = "Success adding your Goal!";
                  this.$router.push(`/myGoals`);
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
        goalId: null,
        goalName : "",
        description: null,
        activityType: [],
        startDate: "",
        endDate: "",
        activityGoal: null,
        activityUnits: "",
        userId: null
   }
 }
}
}

</script>

<style scoped>
body {
    color: #000;
    overflow-x: hidden;
    height: 100%;
    background-image: url("https://i.imgur.com/GMmCQHC.png");
    background-repeat: no-repeat;
    background-size: 100% 100%
}

.card {
    padding: 30px 40px;
    margin-top: 60px;
    margin-bottom: 60px;
    border: none !important;
    box-shadow: 0 6px 12px 0 rgba(0, 0, 0, 0.2)
}

.blue-text {
    color: #00BCD4
}

.form-control-label {
    margin-bottom: 0
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
    font-weight: 300
}

input:focus,
textarea:focus {
    -moz-box-shadow: none !important;
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    border: 1px solid #00BCD4;
    outline-width: 0;
    font-weight: 400
}

.btn-block {
    text-transform: uppercase;
    font-size: 15px !important;
    font-weight: 400;
    height: 43px;
    cursor: pointer
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