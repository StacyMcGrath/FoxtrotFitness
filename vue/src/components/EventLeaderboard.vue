<template>
<div>
  
    <div class="container text-center text-white">
        <div class="row pt-5">
            <div class="col-lg-8 mx-auto">
                <h1 class="display-4">Event Leaderboard</h1>
                <p class="lead mb-0">See where you stand relative to the event community!</p>
            </div>
        </div>
    </div>

    <div class="container py-5">
        <div class="row">
            <div class="col-lg-7 mx-auto bg-white rounded shadow">

                <!-- Fixed header table-->
                <div class="table-responsive">
                    <table>
                        <thead>
                            <tr>
                                <th class="col-1">Rank</th>
                                <th class="col-1">Username</th>
                                <th class="col-1"># of Miles</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="userProfile in userProfiles" v-bind:key="userProfile.handle">
                                <td></td>
                                <td>{{userProfile.handle}}</td>
                                <td>{{totalDistanceForEachUser(userProfile.userId)}}</td>
                            </tr>
                           
                        </tbody>
                    </table>
                </div><!-- End -->
                
            </div>
        </div>
    </div>
</div>
</template>

<script>
import progessService from "../services/ProgressService.js"
import eventService from "../services/EventService.js"
export default {
    name: "event-leaderboard",
    data(){
        return {
            progresses: [],
            event: {},
            userProfiles: [],
            sortBy: 'totalDistanceForEachUser',
            sortDirection: 'asc',
            // sortedUserProfiles: [],
            // profile: {
            //     handle: "",
            //     totalDistance: ""
            // }
        }
    },
    created(){
      progessService.retrieveProgressByEventForAllUsers(this.$route.params.eventId).then(response => {
        this.progresses = response.data;
      }),
      eventService.retrieveEventById(this.$route.params.eventId).then(response => {
        this.event = response.data;
      }),
      eventService.getUsersByEvent(this.$route.params.eventId).then(response => {
          this.userProfiles = response.data;
      })
    },
    methods: {     
        totalDistanceForEachUser(userId){
        let totalDistanceForEachUser = 0;
            this.progresses.forEach(progress => {
            if (progress.userId == userId) {
                totalDistanceForEachUser = totalDistanceForEachUser + progress.distance;
                }
            })
            return totalDistanceForEachUser;
        },
    
    //     sortedProfiles: function() {
    //         return this.userProfiles.sort((u1,u2) => {
    //             if(this.totalDistanceForEachUser(u1.userId) < this.totalDistanceForEachUser(u2.userId)) {
    //                 return -1;
    //             }
    //             else if(this.totalDistanceForEachUser(u1.userId) > this.totalDistanceForEachUser(u2.userId)) { 
    //                 return 1;
    //                 }
    //             else {
    //                 return 0;
    //             }
    //         }); 
            
    //     } 
    // },

    // computed: {
    //     sortedUserProfiles() {
    //         this.userProfiles.forEach(userProfile => {
    //             let totalDistance = this.totalDistanceForEachUser(userProfile.userId);
    //             let handle = userProfile.handle;
                
    //             this.profile.handle = handle;
    //             this.profile.totalDistance = totalDistance;

    //             this.sortedUserProfiles.add(this.profile);

    //         }) 
    //         return this.sortedUserProfiles;
    //     } 

    // },
    
    // watch: {

    // }
    }    
}
 
</script>

<style>

.container py-5 {
    margin: 0;
    padding: 0;
    width: 100%;
}

.table-fixed tbody {
    height: 300px;
    overflow-y: auto;
    width: 100%;

}
h1 {
    font-family: 'Montserrat', sans-serif;
    color: #505170;
}
p {
    font-family: 'Montserrat', sans-serif;
    color: #505170;
}

.table-fixed thead,
.table-fixed tbody,
.table-fixed tr,
.table-fixed td,
.table-fixed th {
    display: block;
}

.table-fixed tbody td,
.table-fixed tbody th,
.table-fixed thead > tr > th {
    float: left;
    position: relative;

    &::after {
        content: '';
        clear: both;
        display: block;
    }
}

body {
    background: #e6e6e6;
    font-family: 'Montserrat', sans-serif;
    color: #505170;
    min-height: 100vh;
}



</style>