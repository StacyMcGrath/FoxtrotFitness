<template>
    <div>
        <!-- <h1>Group Progress</h1>
        <p v-for="(progress, index) in progresses" :key="index">
            User Id: {{progresses[index].userId}} 
            Event Id: {{progresses[index].eventId}} 
            Activity Type Id: {{progresses[index].activityTypeId}} 
            Distance: {{progresses[index].distance.toLocaleString()}} 
            Date: {{progresses[index].activityDate}}
            Total Distance: {{distanceOfAllUsers.toLocaleString()}}
            </p> -->
            <div class="container">
         <div class="row">
            <div class="col-md-6">
            
                <h3 class="progress-title">Community Progress</h3>
                <div class="progress blue">
                    <div class="progress-bar" :style="{width: getProgress}" style="background:#1a4966">
                        <div class="progress-value">{{progressLabel}} %</div>
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
    name: 'group-progress',
    data(){
        return {
            progresses: [],
            event: {}
        }
    },
    computed: {
      distanceOfAllUsers(){
        let distanceOfAllUsers = 0;
        this.progresses.forEach(progress => {
          distanceOfAllUsers = distanceOfAllUsers + progress.distance;
        })
        return distanceOfAllUsers;

      },
      getProgress() {
          let percent = 0;
          percent = ((this.distanceOfAllUsers / this.event.totalActivityGoal)*100);
            if(percent >= 100) {
            return 100 + "%";
          } else {
            return percent + "%";
          }
        

      },
      progressLabel() {
          let progressLabel = 0;
          progressLabel = ((this.distanceOfAllUsers / this.event.totalActivityGoal)*100);
            if(progressLabel >= 100) {
            return 100;
          } else {
            return parseFloat(progressLabel).toFixed(1);
          }
         
      },
      remainingDistance() {
        let remainingDistance = 0;
        remainingDistance = (this.event.totalActivityGoal - this.distanceOfAllUsers);
          if(remainingDistance <=0) {
            return "Congratulations - the goal has been met!";
          } else {
        return remainingDistance.toLocaleString();
      }
      }
    },

    watch: {
          progess(progress) {
              this.currentProgress = progress;
          }
    },

    created(){
      progessService.retrieveProgressByEventForAllUsers(this.$route.params.eventId).then(response => {
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

</style>