<template>
    <div>
        <h1>Group Progress</h1>
        <p v-for="(progress, index) in progresses" v-bind:key="`progress-${index}`">
            User Id: {{progress.userId}} 
            Event Id: {{progress.eventId}} 
            Activity Type Id: {{progress.activityTypeId}} 
            Distance: {{progress.distance}} 
            Date: {{progress.activityDate}}</p>
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
      progessService.retrieveProgressByEventForAllUsers().then(response => {
        this.progress = response.data;
      })
    },

    }
</script>

<style>

</style>