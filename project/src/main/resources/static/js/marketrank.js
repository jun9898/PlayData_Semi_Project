            const marketButton = document.querySelector("#marketButton");



             async function marketRank() {
             let rank=[{"user_seq":null,"market_seq":7,"name":"아웃백스테이크하우스 가산점","url":"naver.com","review_count":5,"star_count":"5","created_at":"2023-10-18T06:48:59.000+00:00"}]

                      let response = await axios.get("/api/content/marketrank");

                      const rankingList = response.data;

                      const listContainer = document.querySelector("#listContainer")
                        $("#listContainer").empty();
                      rankingList.forEach( (rank,index)=> {

                      const listItem = document.createElement("li");

                                  listItem.className = "list-group-item d-flex justify-content-between align-items-center";

                                  listItem.innerHTML = `
                                            <div class="d-flex align-items-center">
                                                <h1 style="margin: 2%;">${index+1}</h1>
                                                <img  alt="" style="width: 45px; height: 45px" class="rounded-circle" >
                                                    ${rank.img_url}</img>
                                                <div class="ms-3">
                                                    <p class="fw-bold mb-1">${rank.name}</p>
                                                    <p class="text-muted mb-0" >${rank.email}</p>
                                                </div>
                                            </div>
                                            <a class="btn btn-secondary btn-rounded" href="#" role="button" >${rank.star_count}</a>
                                        `;
                                        listContainer.append(listItem);

                                    });



                                    if (response.status === 404) {
                                        alert('페이지가 없습니다.');
                                    }
                                } catch (e) {
                                    console.log(e);
                                }
                            }


                            marketButton.addEventListener("click", marketRank);