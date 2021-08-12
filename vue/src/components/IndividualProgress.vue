<template>
    <div>
        <!-- <h1>Individual Progress</h1>
        <p v-for="(progress, index) in progresses" :key="index">
            User Id: {{progresses[index].userId}} 
            Event Id: {{progresses[index].eventId}} 
            Activity Type Id: {{progresses[index].activityTypeId}} 
            Distance: {{progresses[index].distance.toLocaleString()}} 
            Date: {{progresses[index].activityDate}}
            Total Distance: {{totalDistanceOfUser.toLocaleString()}}
            </p> -->
        <div class="container">
         <div class="row">
            <div class="col-md-6">
                <h3 class="progress-title">My Progress</h3>
                <div class="progress green">
                    <div class="progress-bar" :style="{width: getProgress}" style="background:#b6d44a" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                        <div class="progress-value">{{progressLabel.toLocaleString()}}%</div>
                    </div>
                </div>
                <p>Remaining Distance: {{remainingDistance}}</p>
              
                    
            </div>
        </div>
        </div>
    
    </div>
</template>

<script>
import progessService from "../services/ProgressService.js"
import eventService from "../services/EventService.js"
export default {
    name: 'individual-progress',
    data(){
        return {
            progresses: [],
            event: {}
        }
    },
    computed: {
      totalDistanceOfUser(){
        let totalDistanceOfUser = 0;
        this.progresses.forEach(progress => {
          totalDistanceOfUser = totalDistanceOfUser + progress.distance;
        })
        return totalDistanceOfUser;
      },
      getProgress() {
          let percent = 0;
          percent = ((this.totalDistanceOfUser / this.event.userActivityGoal)*100);
          if(percent >= 100) {
            return 100 + "%";
          } else {
            return percent + "%";
          }
      },
      progressLabel() {
          let progressLabel = 0;
          progressLabel = ((this.totalDistanceOfUser / this.event.userActivityGoal)*100);

            if(progressLabel >= 100) {
            return 100;
          } else {
            return parseFloat(progressLabel).toFixed(1);
          }
      },
      remainingDistance() {
        let remainingDistance = 0;
        remainingDistance = ((this.event.userActivityGoal - this.totalDistanceOfUser));
            if(remainingDistance <=0) {
            return "Congratulations - your goal has been met!";
          } else {
        return remainingDistance.toLocaleString();
      }
      }
    },
    created(){
      progessService.retrieveProgressByEventForIndividualUser(this.$route.params.eventId).then(response => {
        this.progresses = response.data;
      });
        eventService.retrieveEventById(this.$route.params.eventId).then(response => {
        this.event = response.data;
      })
    },
    methods: {
      viewEventDetails(eventId) {
        this.$router.push(`/events/${eventId}`);
      }
    }
    }
</script>

<style scoped>
.progress-value {
  color: #505170;
}
</style>