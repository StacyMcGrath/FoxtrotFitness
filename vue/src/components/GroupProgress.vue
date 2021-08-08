<template>
    <div>
        <h1>Group Progress</h1>
        <p v-for="(progress, index) in progresses" :key="index">
            User Id: {{progresses[index].userId}} 
            Event Id: {{progresses[index].eventId}} 
            Activity Type Id: {{progresses[index].activityTypeId}} 
            Distance: {{progresses[index].distance}} 
            Date: {{progresses[index].activityDate}}
            </p>
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