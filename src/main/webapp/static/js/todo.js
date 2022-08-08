document.addEventListener("DOMContentLoaded", () => {
  const list_table = document.querySelector("table.list-table");

  list_table?.addEventListener("click", (e) => {
    const targget = e.target;
    if (targget.className === "donebox") {
      const tr = targget.closest("TR");
      const seq = tr.dataset.seq;
      console.log(seq);

      document.location.href = `${rootPath}/todo/${seq}/done`;
    }
  });
  list_table?.addEventListener("click", (e) => {
    const targget = e.target;
    if (targget.className === "editbox") {
      const tr = targget.closest("TR");
      const seq = tr.dataset.seq;
      console.log(seq);

      document.location.href = `${rootPath}/todo/${seq}/edit`;
    }
  });
});
