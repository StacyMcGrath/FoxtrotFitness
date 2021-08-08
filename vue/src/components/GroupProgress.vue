<template>
    <div>
        <h1>Group Progress</h1>
        <p v-for="(progress, index) in progresses" :key="index">
            User Id: {{progresses[index].userId}} 
            Event Id: {{progresses[index].eventId}} 
            Activity Type Id: {{progresses[index].activityTypeId}} 
            Distance: {{progresses[index].distance}} 
            Date: {{progresses[index].activityDate}}
            Total Distance: {{distanceOfAllUsers}}
            </p>
            <div class="container">
         <div class="row">
            <div class="col-md-6">
                <h3 class="progress-title">My Progress</h3>
                <div class="progress green">
                    <div class="progress-bar" :style="{width: getProgress}" style="background:#b6d44a" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                        <div class="progress-value">20%</div>
                    </div>
                </div>
                <h3 class="progress-title">Community Progress</h3>
                <div class="progress blue">
                    <div class="progress-bar" style="width:90%; background:#1a4966;">
                        <div class="progress-value">90%</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
import progessService from "../services/ProgressService.js"
export default {
    name: 'group-progress',
    data(){
        return {
            progresses: []
        }
    },
    computed: {
      distanceOfAllUsers(){
        let distanceOfAllUsers = 0;
        this.progresses.forEach(progress => {
          distanceOfAllUsers = distanceOfAllUsers + progress.distance;
        })
        return distanceOfAllUsers;

      }
    },
    created(){
      progessService.retrieveProgressByEventForAllUsers(this.$route.params.eventId).then(response => {
        this.progresses = response.data;
      });
    },
    methods: {
      viewEventDetails(eventId) {
        this.$router.push(`/events/${eventId}`);
      }
    }
    }
</script>

<style>

</style>