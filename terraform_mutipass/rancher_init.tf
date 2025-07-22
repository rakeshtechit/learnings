

# Create a mutipass TF instance for Rancher UI
resource "multipass_instance" "rancher_ui" {
  name  = "rancher-ui"
  cpus  = 2
  image = "docker"
  disk = "40GiB"
  memory = "4GiB"
  cloudinit_file = "rancher_ui_cloud_init_file.conf"
}


# Configure the Rancher2 provider to bootstrap
provider "rancher2" {
  api_url   = "http://rancher.mutipass-instance.com"
  bootstrap = true
}

# Configure the Rancher2 provider to bootstrap and admin
# Provider config for bootstrap
provider "rancher2" {
  alias = "bootstrap"
  api_url   = "http://rancher.mutipass-instance.com"
  bootstrap = true
}

#Create a new rancher2_bootstrap using bootstrap provider config
resource "rancher2_bootstrap" "admin" {
  provider = rancher2.bootstrap
  initial_password = "initial-rancher-default-password"
  password = "qwertyuiop[]"
  depends_on = [resource.multipass_instance.rancher_ui]
}

# Provider config for admin
#secret_key="4zvw646kh828tbc6dfzzxgsfdvjd87rvplcpsvjglxjgh9s4k5zccd"
provider "rancher2" {
  alias = "admin"
  api_url = rancher2_bootstrap.admin.url
  token_key = rancher2_bootstrap.admin.token
  #token_key = "token-rqsmf:4zvw646kh828tbc6dfzzxgsfdvjd87rvplcpsvjglxjgh9s4k5zccd"
  insecure = true
  #timeout = "1000s"
}