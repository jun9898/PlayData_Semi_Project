            const marketButton = document.querySelector("#marketButton");



             async function marketRank() {
             let rank=[{"user_seq":null,"market_seq":1,"name":"우진해장국","image_url":null,"review_count":5,"star_count":"5","created_at":"2023- 10-19T15:55:38.000+00:00"},{"user_seq":null,"market_seq":2,"name":"삼청동수제비","image_url":null,"review_count":2,"star_count ":"2","created_at":"2023-10-19T16:37:55.000+00:00"},{"user_seq":null,"market_seq":3,"name":"본수원갈비 본점" ,"image_url":null,"review_count":2,"star_count":"2","created_at":"2023-10-19T16:08:53.000+00:00"},{"user_seq":null," market_seq":4,"name":"이문설농탕","image_url":null,"review_count":2,"star_count":"2","created_at":"2023-10-19T16:29:08.000+00 :00"},{"user_seq":null,"market_seq":5,"name":"고집돌우럭 함덕점","image_url":null,"review_count":2,"star_count":"2", "created_at":"2023-10-19T16:16:51.000+00:00"},{"user_seq":null,"market_seq":2347,"name":"태극당","image_url":null," review_count":2,"star_count":"2","created_at":"2023-10-19T16:52:45.000+00:00"}]

                      let response = await axios.get("/api/content/marketrank");

                      const rankingList = response.data;

                      const listContainer = document.querySelector("#listContainer")
                        $("#listContainer").empty();
                      rankingList.forEach( (rank,index) => {

                      const listItem = document.createElement("li");

                                  listItem.className = "list-group-item d-flex justify-content-between align-items-center";

                                  listItem.innerHTML = `
                                            <div class="d-flex align-items-center">
                                                <h1 style="margin: 2%;">${index+1}</h1>
                                                <img  alt="" style="width: 45px; height: 45px" class="rounded-circle" >
                                                    ${rank.image_url}</img>
                                                <div class="ms-3">
                                                    <p class="fw-bold mb-1">${rank.name}</p>
                                                    <p class="text-muted mb-0" ></p>
                                                </div>
                                            </div>
                                            <a class="btn btn-secondary btn-rounded" href="#" role="button" >${rank.star_count}</a>
                                        `;
                                        listContainer.append(listItem);

                                    });



                                    if (response.status === 404) {
                                        alert('페이지가 없습니다.');
                                    }
                                }



                            marketButton.addEventListener("click", marketRank);