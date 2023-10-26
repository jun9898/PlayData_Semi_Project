
const reviewButton = document.querySelector("#reviewButton");
const categorySelect = document.getElementById("categorySelect");

async function reviewRank() {

    let rank = [{"user_seq":1,"img_url":null,"name":"넘졸령","email":"jun98@gmail.com","review_seq":null,"review_count":2,"recommand_count" :2,"createde_at":null},{"user_seq":2,"img_url":null,"name":"jun","email":"jun98@aaaa.com","review_seq":null," review_count":4,"recommand_count":4,"createde_at":null},{"user_seq":4,"img_url":null,"name":"냠냠","email":"h2@test.com" ,"review_seq":null,"review_count":4,"recommand_count":4,"createde_at":null},{"user_seq":5,"img_url":null,"name":"test","email" :"test@gmail.com","review_seq":null,"review_count":3,"recommand_count":3,"createde_at":null},{"user_seq":7,"img_url":null,"name" :"어린이보호구역안전운전라이더천 현지","email":"testestsset@test.com","review_seq":null,"review_count":1,"recommand_count":1,"createde_at":null},{ "user_seq":8,"img_url":null,"name":"오늘도중고나라에서바쁘게벽돌을배송하는소경민","email":"testsetset@testest.ctest","review_seq":null,"review_count ":1,"recommand_count":1,"createde_at":null}]
    try {
        let response = await axios.get("/api/content/rank");

        const rankingList = response.data;

        const listContainer = document.querySelector("#listContainer");
        $("#listContainer").empty();

        rankingList.forEach( (rank,index) => {

           const listItem = document.createElement("li");
            listItem.className = "list-group-item d-flex justify-content-between align-items-center";

            listItem.innerHTML = `
                <div class="d-flex align-items-center">
                    <h1 style="margin: 2%;">${index+1}</h1>
                    <img alt=""
                        style="width: 45px; height: 45px" class="rounded-circle" >${rank.img_url}</img>
                    <div class="ms-3">
                        <p class="fw-bold mb-1" >${rank.name}</p>
                        <p class="text-muted mb-0" >${rank.email}</p>
                    </div>
                </div>
                <a class="btn btn-secondary btn-rounded" href="#" role="button">${categorySelect.value === "1" ? rank.review_count : rank.recommand_count}</a>
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
window.addEventListener("load", () => {
    reviewRank(categorySelect.value);
});

categorySelect.addEventListener("change", () => {
    reviewRank(categorySelect.value);
});

reviewButton.addEventListener("click", () => {
    reviewRank(categorySelect.value);
});

window.addEventListener("load", reviewRank);
reviewButton.addEventListener("click", reviewRank);
