   M S B A M L   `   `   `  ����I  EohFound_Client, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null/clr-namespace:ohFound_ClientohFound_Client  5      #    ohFound_Client.Löschanfragen   5      W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      .localclr-namespace:ohFound_Client     5      .��5	      � .+�5
   
   �� $ ��Ausstehende Löschanfragen��6   $
��Left=�64   $��	10,10,0,0q�6O   $	��Top=�6b   $	��357��6z   �� 5   
   -   5        $ ��Löschvorgang durchführen��5      $
��Left=�64   $��
10,278,0,0q�6O   $	��Top=�6c   $	��162��6{   6�   �� 5   
   -   5        $��Fertig��5      $
��Left=�6"   $��695,380,0,0q�6=   $	��Top=�6R   $��75��6j   6u   &   System.Windows.Controls.DataGrid  5   
   -   5           Name$  dg_Items��5      $
��Left=�6>   $	��232��6Y   $��	10,41,0,0q�6f   $	��Top=�6y   $	��760��6�      AutoGenerateColumns .  ��6%   ��    Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Item ID��6%      
IsReadOnly . 1  +System.Windows.Controls.DataGridBoundColumn   Binding 66   �� *	Item_id+6R     5      $ Title��6%    .  64   �� *Title+6N     5      $ Description��6%    .  6:   �� *Description+6Z     5      $ 	Published��6%    .  68   �� *	Published+6V     5      $ Marked for deletion��6%    .  6B   �� *Marked_for_deletion+6j   5      5      5      