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

    <!-- <div class="container py-5">
        <div class="row">
            <div class="col-lg-7 mx-auto bg-white rounded shadow">

                
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
                            <tr v-for="(userProfile, index) in sortedUserProfiles" v-bind:key="userProfile.handle">
                                <td>{{index+ 1}}</td>
                                <td>{{userProfile.handle}}</td>
                                <td>{{totalDistanceForEachUser(userProfile.userId)}}</td>
                            </tr>
                           
                        </tbody>
                    </table>
                </div>
                
            </div>
        </div>
    </div> -->
    <div class="listcontainer">
      
        
        <ul class="table-responsive">
          <li class="table-header">
            <div class="col col-1">Rank</div>
            <div class="col col-2">Username</div>
            <div class="col col-3"># of Miles</div>
          </li>
          <li class="table-row" v-for="(userProfile, index) in sortedUserProfiles" v-bind:key="userProfile.handle">
            <div class="col col-1" data-label="Rank">{{index+ 1}}</div>
            <div class="col col-2" data-label="Username">{{userProfile.handle}}</div>
            <div class="col col-3" data-label="Distance">{{totalDistanceForEachUser(userProfile.userId)}}</div>
          </li>
        </ul> 
      
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
            sortedProfiles: [] 
        };
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

    computed: {
      sortedUserProfiles: function(){
          return [...this.userProfiles].sort((u1,u2) => {
                if(this.totalDistanceForEachUser(u1.userId) < this.totalDistanceForEachUser(u2.userId)) {
                    return 1;
                }
                else if(this.totalDistanceForEachUser(u1.userId) > this.totalDistanceForEachUser(u2.userId)) { 
                    return -1;
                    }
                else {
                    return 0;
                }
            });   
      }  
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
    },
       
}


</script>

<style scoped>

.container py-5 {
    margin: 0;
    padding: 0;
    max-width: 100%;
}

/* .table-fixed tbody {
    height: 300px;
    overflow-y: auto;
    width: 100%;

} */
h1 {
    font-family: 'Montserrat', sans-serif;
    color: #505170;
}
p {
    font-family: 'Montserrat', sans-serif;
    color: #505170;
}

/* .table-fixed thead,
.table-fixed tbody,
.table-fixed tr,
.table-fixed td,
.table-fixed th {
    display: block;
} */

/* .table-fixed tbody td,
.table-fixed tbody th,
.table-fixed thead > tr > th {
    float: left;
    position: relative;

    &::after {
        content: '';
        clear: both;
        display: block;
    }
} */

body {
    background: #e6e6e6;
    font-family: 'Montserrat', sans-serif;
    color: #505170;
    min-height: 100vh;
}
.listcontainer {
  max-width: 50%;
  margin-left: auto;
  margin-right: auto;
  padding-left: 10px;
  padding-right: 10px;
}
li {
    border-radius: 3px;
    padding: 5px 30px;
    display: flex;
    justify-content: space-between;
    margin-bottom: 5px;
  }
  .table-header {
     background-color: #e6e6e6;
    font-size: 14px;
    text-transform: uppercase;
    letter-spacing: 0.03em;
    font-weight: bold;
    vertical-align: bottom;
    margin-bottom: 0%;
  }
  .table-row {
    background-color: #ffffff;
    box-shadow: 0px 0px 9px 0px rgba(0,0,0,0.1);
    
  }
  .table-row:nth-child(odd) {
  background: #edf0db;
  }
  .table-row:nth-child(even) {
    background: #cfe6e0;
    
  }
  .col-1 {
    flex-basis: 1fr;
  }
  .col-2 {
    flex-basis: 1fr;
  }
  .col-3 {
    flex-basis: 1fr;
  }



</style>