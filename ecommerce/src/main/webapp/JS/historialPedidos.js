window.onload = () => {
    const host = "http://localhost:8080/api";
    const sectionProductos = document.getElementById("rectangulo-centro");
    let pedidos = [];

    const init = () => {

    };

    const obtenerPedidos = () => {

    };

    const cargarPedidos = () => {
        pedidos.forEach(pedido => {
            pedido.detallesPedido.forEach(detalle => {
                const divProducto = document.createElement("div");
            });
        });
    };

    init();
};
