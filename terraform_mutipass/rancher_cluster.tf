# Create a new rancher v2 RKE2 custom Cluster v2
resource "rancher2_cluster_v2" "primary_cluster" {
  name = "r2-primary-cluster"
  kubernetes_version = "v1.24.8-rancher1-1"
  enable_network_policy = false
}

# Create a mutipass TF instance for Rancher UI
# resource "multipass_instance" "rancher_node_a" {
#   name  = "rancher-node-a"
#   cpus  = 2
#   image = "docker"
#   disk = "40GiB"
#   memory = "4GiB"
#   cloudinit_file = "rancher_cluster_cloud_init_file.conf"
# }