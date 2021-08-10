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
                            <tr>
                                <td>1</td>
                                <td>Faisal</td>
                                <td>20</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Katy</td>
                                <td>15</td>
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
            users: {},
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
    computed: {     
        totalDistanceOfUser(){
        let totalDistanceOfUser = 0;
        this.progresses.forEach(progress => {
            if (this.progress.userId == 4) {
                totalDistanceOfUser = totalDistanceOfUser + progress.distance;
            }
        })
        return totalDistanceOfUser;
      },
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